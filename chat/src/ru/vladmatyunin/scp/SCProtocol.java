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

    public SCProtocol(SCProtocolType type, Message message) {
        this.type = type;
        this.message = message;
    }

    public SCProtocol(SCProtocolType type, Command command) {
        this.type = type;
        this.command = command;
    }

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
