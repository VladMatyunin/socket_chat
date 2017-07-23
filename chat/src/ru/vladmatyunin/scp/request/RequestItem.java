package ru.vladmatyunin.scp.request;

/**
 * Created by Vlad on 23.07.2017.
 */
public class RequestItem {
    private String property;
    private Object value;
    private Class valueType;

    public RequestItem(String property, Object value, Class valueType) {
        this.property = property;
        this.value = value;
        this.valueType = valueType;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Class getValueType() {
        return valueType;
    }

    public void setValueType(Class valueType) {
        this.valueType = valueType;
    }
}
