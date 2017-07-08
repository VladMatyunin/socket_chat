package ru.vladmatyunin.server.user;

import ru.vladmatyunin.entity.User;

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
}
