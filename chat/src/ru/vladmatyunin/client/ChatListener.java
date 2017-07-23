package ru.vladmatyunin.client;

import ru.vladmatyunin.entity.Message;
import ru.vladmatyunin.scp.Command;

import java.io.IOException;

/**
 * @author Vlad Matyunin
 * Interface to connect a Client with other Clients in one chat.
 * This is a kind of Client join to server
 */
public interface ChatListener {
    /**
     * Called when chat gets message from one client.
     * Needed in order to send received message to other clients
     * @param message - the received message to send
     */
    void onMessageReceived(Message message) throws IOException;

    /**
     * Called when command from client received
     * @param command - the command to send to other users in chat
     */
    void onCommandReceived(Command command) throws IOException;
}
