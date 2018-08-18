package org.mySpring.beans;

public interface BeanDefinition {

    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";
    String SCOPE_DEFAULT = "singleton";

    String getBeanClassName();
    boolean isSingleton();
    boolean isPrototype();
    void setScope(String scope);
    public String getScope();

}
