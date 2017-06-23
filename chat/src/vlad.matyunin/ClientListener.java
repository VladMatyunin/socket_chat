package ru.vladmatyunin;

/**
 * Created by Vlad on 23.06.2017.
 */
public interface ClientListener {
    void onMessageSent(String message);
    void onCommandSent();
}
