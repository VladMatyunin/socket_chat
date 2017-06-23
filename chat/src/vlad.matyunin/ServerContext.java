package ru.vladmatyunin;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vlad on 23.06.2017.
 */
public class ServerContext {
    private Set<Chat> chats;
    private ServerContext context;
    private ServerContext(){
        chats = new HashSet<>();
    }
    public ServerContext getInstance(){
        if (context==null) return new ServerContext();
        else return context;
    }
    public Chat createChat(Client admin){
        Chat createdChat = new Chat(admin);
        chats.add(createdChat);
        return createdChat;
    }
}
