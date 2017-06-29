package ru.vladmatyunin.server;

import ru.vladmatyunin.chat.Chat;
import ru.vladmatyunin.client.Client;
import ru.vladmatyunin.server.logger.MessageLogger;
import ru.vladmatyunin.server.logger.MessageLoggerService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vlad Matyunin
 * This class stores all chats and services, based on pattern
 * Context and Singleton.
 *
 * Field description:
 *
 * -chats is a map, where key is chatId
 * @see Chat
 *
 * -context is a singleton entity
 */
public class ServerContext {

    private static Map<Long, Chat> chats;
    private ServerContext context;
    private static Map<Class,ServerService> services;

    static {
        services = new HashMap<Class,ServerService>();
        services.put(MessageLogger.class,new MessageLoggerService());
        chats = new HashMap<>();
    }
    private ServerContext(){


    }
    public ServerContext getInstance(){
        if (context==null) return new ServerContext();
        else return context;
    }

    /**
     * This method creates new chat
     * @param admin - is a client, who has just created a chat.
     *              Becomes automatically admin of the chat
     * @return the created chat
     * @see Chat
     */
    public static Chat createChat(Client admin){
        Chat createdChat = new Chat(admin);
        chats.put(createdChat.getChatId(),createdChat);
        return createdChat;
    }

    /**
     * This method joints current client to chat
     * @param chatId - the id of chat to join
     * @param client - the client to join the chat
     */
    public static void joinChat(Long chatId, Client client){
        chats.get(chatId).setClient(client);
    }
    public static ServerService lookUpService(Class aclass){
        return services.get(aclass);
    }
    public static ServerService lookUpService(String name){
        return null;
        //TODO: findByName
    }
}
