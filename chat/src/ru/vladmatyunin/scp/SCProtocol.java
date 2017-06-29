package ru.vladmatyunin.scp;

import ru.vladmatyunin.entity.Message;

import java.util.Optional;

/**
 * Created by Vlad on 23.06.2017.
 */
public class SCProtocol {
    public SCProtocolType type;
    private Message message;
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }
    void setMessage(Message message){
        this.message = message;
    }
    public Optional<Command> getCommand(){
        return Optional.ofNullable(command);
    }
    public Optional<Message> getMessage(){
        return Optional.ofNullable(message);
    }
}
