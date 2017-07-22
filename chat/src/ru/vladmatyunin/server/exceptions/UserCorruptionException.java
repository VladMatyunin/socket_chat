package ru.vladmatyunin.server.exceptions;

/**
 * Exception thrown when somebody tries to corrupt his or her token
 * @see ru.vladmatyunin.server.user.UserService, method getByToken()
 */
public class UserCorruptionException extends Exception {
}
