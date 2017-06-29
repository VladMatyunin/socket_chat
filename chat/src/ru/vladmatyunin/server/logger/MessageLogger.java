package ru.vladmatyunin.server.logger;

import ru.vladmatyunin.entity.Message;
import ru.vladmatyunin.server.ServerService;

/**
 * Created by Vlad on 29.06.2017.
 */
public interface MessageLogger extends ServerService {
    final String LOGS_PATH = "/path/to/file";
    default void logMessage(Message message){

    }

    @Override
    default String getName() {
        return "messageLogger";
    }
}
