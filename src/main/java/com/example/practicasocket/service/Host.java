package com.example.practicasocket.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Host {

    public static void main(String[] args) {
    Logger log = Logger.getLogger(String.valueOf(Host.class));

    int puerto = 5052;
    int maximoConexiones = 10; // Maximo de conexiones simultaneas
    ServerSocket servidor = null ;
    Socket socket = null;
    MessageChat message = new MessageChat();

    try {
        // Se crea el serverSocket
        servidor = new ServerSocket(puerto,maximoConexiones);

        // Bucle infinito para esperar conexiones
        while (true) {
            log.info("Servidor a la espera de conexiones.");
            socket = servidor.accept();
            log.info("Cliente con la IP " + socket.getInetAddress().getHostName() + " conectado.");
            ClientConection cc = new ClientConection(socket,message);
            cc.start();
        }
    } catch (IOException ex) {
        // log.error("Error: " + ex.getMessage());
    } finally{
        try {
            socket.close();
            servidor.close();
        } catch (IOException ex) {
            // log.error("Error al cerrar el servidor: " + ex.getMessage());
        }
    }
}
}
