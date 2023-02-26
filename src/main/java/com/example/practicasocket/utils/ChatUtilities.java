package com.example.practicasocket.utils;

import com.example.practicasocket.service.ClientChat;
import javafx.scene.control.TextArea;

public class ChatUtilities extends Thread {

    @Override
    public void run() {
        try {
            ClientChat.recibirMensajesServidor();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
