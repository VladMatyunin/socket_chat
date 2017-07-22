package ru.vladmatyunin.server.user;

import ru.vladmatyunin.entity.Credentials;
import ru.vladmatyunin.entity.User;
import ru.vladmatyunin.server.exceptions.UserNotFoundException;

/**
 * Created by Vlad on 08.07.2017.
 */
public class UserChatService implements UserService {
    @Override
    public String getName() {
        return "userChatService";
    }

    @Override
    public User getByToken(String token) {
        //TODO: check if there is such user
        return null;
    }

    @Override
    public User registerUser(Credentials credentials) {
        //TODO
        return null;
    }

    @Override
    public User loginUser(Credentials credentials) throws UserNotFoundException {
        //TODO
        return null;
    }
}
