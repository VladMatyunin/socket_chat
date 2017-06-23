package ru.vladmatyunin;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Vlad on 23.06.2017.
 */
public class Client extends Thread implements ChatListener {
    private ClientListener listener;
    private Socket socket;
    public void setListener(ClientListener l){
        listener = l;
    }
    public Client(Socket socket){
        this.socket = socket;
    }
    public Client(Socket socket, ClientListener listener){
        this(socket);
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

    }
}
