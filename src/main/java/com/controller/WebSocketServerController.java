package com.javashitang.controller;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Component
@ServerEndpoint("/forshow/websocket/{sid}")
public class WebSocketServerController {


// method called after receiving the message
    @OnMessage
    public void onMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


// method to establish a connection
    @OnOpen
    public void onOpen(@PathParam("sid") String sid) {
        System.out.println("Client connected");
    }


// method called to close the connection
    @OnClose
    public void onClose() {
        System.out.println("Connection closed");
    }

// method called when transmitting a message error
    @OnError
    public void OnError(Throwable error) {
        System.out.println("Connection error");
    }
}
