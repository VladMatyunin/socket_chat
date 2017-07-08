package ru.vladmatyunin.server.user;

import ru.vladmatyunin.entity.User;
import ru.vladmatyunin.server.ServerService;

/**
 * Created by Vlad on 08.07.2017.
 */
public interface UserService extends ServerService {
    User getByToken(String token);
}
