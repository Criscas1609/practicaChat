package com.example.practicasocket.controller;

import com.example.practicasocket.service.ClientChat;
import com.example.practicasocket.utils.ChatUtilities;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientViewController implements Initializable {

    static Socket socket;
    static String username;
    String host;
    static String port;
    @FXML
    private Label chatArea;
    @FXML
    private TextArea chatText;

    @FXML
    private TextField inputText;


    @FXML
    void sendText(ActionEvent event) {
        ClientChat.getData(chatText);
        ClientChat.conection(host, port,username,inputText,event);
        ChatUtilities hilo1 = new ChatUtilities();
        hilo1.start();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ChatUtilities hilo1 = new ChatUtilities();
        hilo1.start();
    }

    public static void getData(Socket socket1, String username1, String port1){
        port = port1;
        socket = socket1;
        username = username1;
    }
}

