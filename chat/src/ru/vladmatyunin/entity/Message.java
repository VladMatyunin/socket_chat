package ru.vladmatyunin.entity;

import java.util.Date;
import java.util.Optional;

/**
 * Created by Vlad on 29.06.2017.
 */
public class Message {

    private User sender;

    private Date dateSent;

    private String text;

    private Message(){}

    public static class MessageBuilder{
        private Message message;
        public MessageBuilder(){
            message = new Message();
        }
        public MessageBuilder sender(User user){
            message.sender = user;
            return this;
        }
        public MessageBuilder dateSent(Date date){
            message.dateSent = date;
            return this;

        }
        public MessageBuilder text(String text){
            message.text = text;
            return this;
        }
        public Message build(){
            return message;
        }
    }

    public Date getDateSent() {
        return dateSent;
    }

    public String getText() {
        return text;
    }

    public User getSender() {
        return sender;
    }

    /**
     * Converts Message to String, which will be then sent to other users
     * @return String in SCP type style
     */
    public String getSCPTypeMessage(){
        StringBuilder builder = new StringBuilder("MESSAGE::");
        builder.append(" FROM::")
                .append(sender.toString())
                .append(" DATE::")
                .append(dateSent.toString())
                .append(" TEXT::")
                .append(text);
        return builder.toString();
    }
}
