package ru.vladmatyunin.client;

import ru.vladmatyunin.chat.ClientListener;
import ru.vladmatyunin.entity.Message;
import ru.vladmatyunin.entity.User;
import ru.vladmatyunin.scp.Command;
import ru.vladmatyunin.scp.SCPFactory;
import ru.vladmatyunin.scp.SCProtocol;
import ru.vladmatyunin.scp.SCProtocolType;
import ru.vladmatyunin.scp.exceptions.ScpParseException;

import java.io.*;
import java.net.Socket;

/**
 * Created by Vlad on 23.06.2017.
 */
public class Client extends Thread implements ChatListener {

    private ClientListener listener;
    private Socket socket;
    private User user;
    private BufferedWriter writer;


    public void setListener(ClientListener l) {
        listener = l;
    }

    public Client(Socket socket, User user) {
        this.socket = socket;
    }

    public Client(Socket socket, User user, ClientListener listener) throws IOException {
        this(socket, user);
        this.listener = listener;
        this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    @Override
    public void run() {
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (reader.readLine() != null) {
                    String text = reader.readLine();
                    stringBuilder.append(text);
                }
                SCProtocol protocol = SCPFactory.getSCP(stringBuilder.toString());

                if (protocol.type.equals(SCProtocolType.MESSAGE)) {
                    listener.onMessageSent(protocol.getMessage().get());
                }

                else if (protocol.type.equals(SCProtocolType.COMMAND)) {
                    listener.onCommandSent(protocol.getCommand().get());
                }
            } catch (IOException | ScpParseException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onMessageReceived(Message message) throws IOException {
        writer.write(message.getSCPTypeMessage());
    }

    @Override
    public void onCommandReceived(Command command) throws IOException {
        writer.write(command.toString());
    }
}
