package ru.vladmatyunin.client;

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
    void onMessageReceived(String message);
}
