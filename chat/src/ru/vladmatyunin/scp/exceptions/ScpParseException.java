package ru.vladmatyunin.scp.exceptions;

/**
 * Created by Vlad on 08.07.2017.
 */
public class ScpParseException extends Exception {
    @Override
    public String getMessage() {
        return "wrong text content, should start with MESSAGE:: or COMMAND::";
    }
}
