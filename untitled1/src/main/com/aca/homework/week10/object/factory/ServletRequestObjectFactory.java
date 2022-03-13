package com.aca.homework.week10.object.factory;

public class ServletRequestObjectFactory<T extends ServletRequest> implements ObjectFactory<T> {

    @Override
    public T getObject() {
        return (T) new ServletRequestImpl();
    }
}