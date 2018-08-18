package org.mySpring.beans.factory.support;

import org.mySpring.beans.BeanDefinition;

public interface BeanDefinitionRegistry {
    public BeanDefinition getBeanDefinition(String beanId);
    public void registerBeanDefinition(String beanId,BeanDefinition bd);
}
