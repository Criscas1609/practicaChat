package com.example.practicasocket.controller;

import com.example.practicasocket.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.Socket;

public class SettingViewController {

    static Socket socket;

    @FXML
    private TextField inputHost;

    @FXML
    private  TextField inputPort;

    @FXML
    private TextField inputName;

    @FXML
    void loadButton(ActionEvent event) throws IOException {
        socket = new Socket(inputHost.getText(), Integer.parseInt(inputPort.getText()));
        ClientViewController.getData(socket,inputName.getText(),inputPort.getText());
        HelloApplication.chatView(event);
    }

    public String getUserName() {
        return inputName.getText();
    }
    public String getPort() {
        return inputPort.getText();
    }
    public String getHost() {
        return inputHost.getText();
    }
    public Socket getSocket() {
        return socket;
    }

}
