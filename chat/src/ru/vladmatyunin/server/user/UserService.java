package ru.vladmatyunin.server.user;

import ru.vladmatyunin.entity.Credentials;
import ru.vladmatyunin.entity.User;
import ru.vladmatyunin.server.ServerService;
import ru.vladmatyunin.server.exceptions.UserCorruptionException;
import ru.vladmatyunin.server.exceptions.UserNotFoundException;

/**
 * Service to handle Authentication and Authorization logic
 * Uses token based authentication
 */
public interface UserService extends ServerService {

    /**
     * method to call each time message got from user
     * check token
     */
    User getByToken(String token) throws UserCorruptionException;

    /**
     * if Command REGISTER came from user, then register new user
     * @param credentials - his or her name and password
     * @return created user
     */
    User registerUser(Credentials credentials);

    /**
     * Gets cred. from user, while trying to authorize, sending command AUTHORIZE
     * @param credentials - the name and password
     * @return prepared user from context
     * @throws UserNotFoundException if such user not found
     */
    User loginUser(Credentials credentials) throws UserNotFoundException;

}
