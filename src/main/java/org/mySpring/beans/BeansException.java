package org.mySpring.beans;

public class BeansException extends RuntimeException {

    private String beanClassName;

    public BeansException(String msg){
        super(msg);
    }

    public BeansException(String msg,Throwable cause){
        super(msg,cause);
    }

}
