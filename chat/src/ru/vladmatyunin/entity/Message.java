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

    class MessageBuilder{
        private Message message;
        public MessageBuilder(){
            message = new Message();
        }
        public MessageBuilder sender(User user){
            message.sender = user;
            return this;
        }
        public MessageBuilder dateSent(Date date){
            dateSent = date;
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

}
