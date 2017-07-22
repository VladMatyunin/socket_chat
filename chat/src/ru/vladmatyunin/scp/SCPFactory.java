package ru.vladmatyunin.scp;

import ru.vladmatyunin.entity.Message;
import ru.vladmatyunin.scp.exceptions.ScpParseException;

import java.util.Date;

/**
 * Factory to convert income String to SCP (Socket Chat Protocol) Protocol
 * @see SCProtocol
 */
public class SCPFactory {
    public static SCProtocol getSCP(String text) throws ScpParseException {
        if (text.startsWith("COMMAND::")) {
            return new SCProtocol(Command.values()[Integer.parseInt(text.split("\\s+")[1])]);
        }

        if (text.startsWith("MESSAGE::")) {
            return new SCProtocol(
                    new Message.MessageBuilder()
                            .dateSent(new Date())
                            .text(text.substring(10))
                            .build());
        }
        //if both command and message
        if (text.startsWith("COMPLEX::")) {
            int messageIndex = text.indexOf("MESSAGE::");
            SCProtocol command = getSCP(text.substring(9,messageIndex));
            SCProtocol message = getSCP(text.substring(messageIndex,text.length()));
        }
        throw new ScpParseException();
    }

    //joins command from first protocol message and message from another, helper method
    private static SCProtocol join(final SCProtocol command, final SCProtocol message){
        return  new SCProtocol(command.getCommand().get(), message.getMessage().get());
    }
}
