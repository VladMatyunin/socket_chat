package ru.vladmatyunin.scp;

import ru.vladmatyunin.entity.Message;

import java.util.Optional;

/**
 * SCP - Socket Chat Protocol
 * Protocol to handle messaging between clients
 *
 * 3 types of income messages:
 * 1) Only Message - while chatting to easy and fast message parsing
 * 2) Only Command - sent command will be checked and then action will be completed
 * 3) Mixed or Complex - when user sent both message and command, very rarely, but necessary
 *
 */
public class SCProtocol {
    public SCProtocolType type;
    private Message message;
    private Command command;

    public SCProtocol(Message message) {
        this.type = SCProtocolType.MESSAGE;
        this.message = message;
    }

    public SCProtocol( Command command) {
        this.type = SCProtocolType.COMMAND;
        this.command = command;
    }

    public SCProtocol(Command command, Message message){
        this.type = SCProtocolType.COMPLEX;
        this.message = message;
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
