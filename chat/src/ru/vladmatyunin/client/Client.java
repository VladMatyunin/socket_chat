package ru.vladmatyunin.client;

import ru.vladmatyunin.chat.ClientListener;
import ru.vladmatyunin.entity.User;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Vlad on 23.06.2017.
 */
public class Client extends Thread implements ChatListener {
    private ClientListener listener;
    private Socket socket;
    private User user;
    public void setListener(ClientListener l){
        listener = l;
    }
    public Client(Socket socket, User user){
        this.socket = socket;
    }
    public Client(Socket socket,User user, ClientListener listener){
        this(socket,user);
        this.listener = listener;
    }

    @Override
    public void run() {
        while (true){
            try {
                socket.getOutputStream();
                listener.onMessageSent("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onMessageReceived(String message) {
        // TODO: write to socket the message
    }
}
