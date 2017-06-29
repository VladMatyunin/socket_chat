package ru.vladmatyunin.server;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Vlad on 29.06.2017.
 */
public interface ServerService {
    default String getName(){
        throw new NotImplementedException();
    }
}
