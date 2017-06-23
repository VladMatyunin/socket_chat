package ru.vladmatyunin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Vlad on 23.06.2017.
 */
public class UnauthorizedClient extends Thread {
    private Socket socket;

    public UnauthorizedClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                String text = reader.readLine();
                SCProtocol protocol = SCPFactory.getSCP(text);
                if (protocol.type.equals(SCProtocolType.COMMAND)) {
                    Client client = new Client(socket);
                    Chat chat = new Chat(client);

                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
