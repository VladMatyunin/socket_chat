package ru.vladmatyunin.scp.exceptions;

/**
 * Exception thrown while parsing in Factory
 * @see ru.vladmatyunin.scp.SCPFactory
 */
public class ScpParseException extends Exception {
    @Override
    public String getMessage() {
        return "wrong text content, should start with MESSAGE:: or COMMAND:: (rarely COMPLEX::)";
    }
}
