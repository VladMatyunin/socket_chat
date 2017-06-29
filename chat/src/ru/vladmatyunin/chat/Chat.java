package ru.vladmatyunin.chat;

import ru.vladmatyunin.client.ChatListener;
import ru.vladmatyunin.client.Client;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Vlad on 23.06.2017.
 */
public class Chat implements ClientListener{
    public Chat(Client admin){
        clients = new HashSet<>();
        clients.add(admin);
        admin.setListener(this);
        chatId = new Random().nextLong();
    }
    private Set<ChatListener> clients;
    private Long chatId;
    public void setClient(ChatListener client){
        clients.add(client);
    }

    @Override
    public void onMessageSent(String message) {
        for (ChatListener listener: clients){
            listener.onMessageReceived(message);
        }
    }

    @Override
    public void onCommandSent() {
        //TODO: send command
    }

    public Long getChatId() {
        return chatId;
    }
}
