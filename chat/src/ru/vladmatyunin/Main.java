package ru.vladmatyunin;

import ru.vladmatyunin.client.UnauthorizedClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            ServerSocket socket = new ServerSocket(1000);
            while (true){
                Socket clientSocket = socket.accept();
                new UnauthorizedClient(clientSocket).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
