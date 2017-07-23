package ru.vladmatyunin.chat;

import ru.vladmatyunin.entity.Message;
import ru.vladmatyunin.scp.Command;

/**
 * @author Vlad Matyunin
 *
 * This listener controls client.
 * If the client sends a message, the <code>onMessageSent() called</code>
 * If the client sends a command (e.g. destroy a chat or block user)
 * <code>onCommandSent()</code> is called
 *
 * Actually, this interface is for chat
 */
public interface ClientListener {
    /**
     * Method to be called, when client sends a message, so that all other
     * users get the message
     * @param message - the Message from user(Client)
     *                @see ru.vladmatyunin.client.Client
     */
    void onMessageSent(Message message);

    /**
     * Called when client sends a command
     */
    void onCommandSent(Command command);
}
