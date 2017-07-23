package ru.vladmatyunin.scp.request;

/**
 * Created by Vlad on 23.07.2017.
 */
public class Request<T> {
    private RequestType requestType;

    public static SelectRequest select(Class tClass){
        return new SelectRequest();
    }

}
