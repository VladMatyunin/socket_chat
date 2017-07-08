package ru.vladmatyunin.client;

import ru.vladmatyunin.chat.Chat;
import ru.vladmatyunin.entity.User;
import ru.vladmatyunin.scp.SCPFactory;
import ru.vladmatyunin.scp.SCProtocol;
import ru.vladmatyunin.scp.SCProtocolType;
import ru.vladmatyunin.scp.exceptions.ScpParseException;

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
                    Client client = new Client(socket,new User());
                    //TODO: check - if command is CREATE_CHAT, then create, else join
                    Chat chat = new Chat(client);
                    break;
                }
            }
        }
        catch (ScpParseException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
