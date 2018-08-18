package org.mySpring.beans.factory;

import org.mySpring.beans.BeansException;

public class BeanCreationException extends BeansException {

    private String beanClassName;

    public BeanCreationException(String msg) {
        super(msg);
    }

    public BeanCreationException(String beanClassName, String msg) {
        super("Error create bean with name '"+beanClassName+"': "+msg);
        this.beanClassName = beanClassName;
    }
}
