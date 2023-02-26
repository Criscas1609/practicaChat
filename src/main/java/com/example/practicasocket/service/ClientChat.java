package com.example.practicasocket.service;

import javafx.event.ActionEvent;
import javafx.scene.AccessibleAction;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.net.Socket;

public class ClientChat {
    private static Socket socket;

    public static void conection(String host, String puerto, String username, TextField inputText, ActionEvent event) {
        try {
            socket = new Socket(host, Integer.parseInt(puerto));
        } catch (
                IOException ex) {
            //  log.error("No se ha podido conectar con el servidor (" + ex.getMessage() + ").");
        }
        new ServerConection(socket, inputText,username);
        ServerConection.accion();
    }
    public static void recibirMensajesServidor(){
        TextArea textArea = new TextArea();
        // Obtiene el flujo de entrada del socket
        DataInputStream entradaDatos = null;
        String mensaje;
        try {
            entradaDatos = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            // log.error("Error al crear el stream de entrada: " + ex.getMessage());
        } catch (NullPointerException ex) {
            // log.error("El socket no se creo correctamente. ");
        }

        // Bucle infinito que recibe mensajes del servidor
        boolean conectado = true;
        while (conectado) {
            try {
                mensaje = entradaDatos.readUTF();
                textArea.setText(textArea.getText()+(mensaje + System.lineSeparator()));
            } catch (IOException ex) {
                //  log.error("Error al leer del stream de entrada: " + ex.getMessage());
                conectado = false;
            } catch (NullPointerException ex) {
                // log.error("El socket no se creo correctamente. ");
                conectado = false;
            }
        }
    }
}
