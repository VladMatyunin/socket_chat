package ru.vladmatyunin.scp;

import ru.vladmatyunin.entity.Message;
import ru.vladmatyunin.scp.exceptions.ScpParseException;

import java.util.Date;

/**
 * Created by Vlad on 23.06.2017.
 */
public class SCPFactory {
    public static SCProtocol getSCP(String text) throws ScpParseException {
        if (text.startsWith("COMMAND::")) {
            return new SCProtocol(SCProtocolType.COMMAND,
                    Command.values()[Integer.parseInt(text.split("\\s+")[1])]);
        }

        if (text.startsWith("MESSAGE::")) {
            return new SCProtocol(SCProtocolType.MESSAGE,
                    new Message.MessageBuilder()
                            .dateSent(new Date())
                            .text(text.substring(10))
                            .build());
        }
        throw new ScpParseException();
    }
}
