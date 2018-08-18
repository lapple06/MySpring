package org.mySpring.beans.factory.config;

import org.mySpring.beans.factory.BeanFactory;

public interface ConfigurableBeanFactory extends BeanFactory{
    public void setClassLoader(ClassLoader classLoader);
    public ClassLoader getClassLoader();
}
