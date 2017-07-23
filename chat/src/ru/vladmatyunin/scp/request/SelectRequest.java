package ru.vladmatyunin.scp.request;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vlad on 23.07.2017.
 */
public class SelectRequest<T> extends Request<T> {

    private List<RequestItem> requestItems;
    private int number = 1;
    private boolean ASC = true;
    SelectRequest(){
        requestItems = new ArrayList<>();
    }

    public SelectRequest itemsNumber(int number, boolean ASC){
        this.ASC = ASC;
        return this;
    }
    public SelectRequest where(RequestItem item){
        requestItems.add(item);
        return this;
    }
    public SelectRequest and(){
        return this;
    }

}
