package org.mySpring.beans.factory.support;

import org.mySpring.beans.BeanDefinition;

public class GenericBeanDefinition implements BeanDefinition {

    private String id;
    private String beanClassName;
    private boolean isSingleton = true;
    private boolean isPrototype = false;
    private String scope = BeanDefinition.SCOPE_DEFAULT;


    public GenericBeanDefinition(String id, String beanClassName){
        this.id = id;
        this.beanClassName = beanClassName;
    }


    @Override
    public String getBeanClassName() {
        return this.beanClassName;
    }

    @Override
    public boolean isSingleton() {
        return this.isSingleton;
    }

    @Override
    public boolean isPrototype() {
        return this.isPrototype;
    }

    @Override
    public void setScope(String scope) {
        this.scope = scope;
        this.isSingleton = BeanDefinition.SCOPE_SINGLETON.equals(scope) || BeanDefinition.SCOPE_DEFAULT.equals(scope);
        this.isPrototype = BeanDefinition.SCOPE_PROTOTYPE.equals(scope);
    }

    @Override
    public String getScope() {
        return this.scope;
    }
}
