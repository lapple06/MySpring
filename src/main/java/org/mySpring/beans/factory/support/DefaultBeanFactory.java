package org.mySpring.beans.factory.support;

import org.mySpring.beans.BeanDefinition;
import org.mySpring.beans.factory.BeanCreationException;
import org.mySpring.beans.factory.config.ConfigurableBeanFactory;
import org.mySpring.utils.ClassUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultBeanFactory extends DefaultSingletonBeanRegistry
        implements ConfigurableBeanFactory,BeanDefinitionRegistry {

    private Map<String,BeanDefinition> beanDefinationMap = new ConcurrentHashMap<>();

    private ClassLoader classLoader;

    @Override
    public Object getBean(String beanId){
        BeanDefinition beanDefinition = this.getBeanDefinition(beanId);
        if(beanDefinition ==null){
            throw new BeanCreationException("bean defination does not exist");
        }

        if(beanDefinition.getScope().equals(BeanDefinition.SCOPE_SINGLETON)){
            Object bean = this.getSingleton(beanId);
            if(bean==null){
                bean = createBean(beanDefinition);
                this.registerSingleton(beanId,bean);
            }
            return bean;

        }
        return createBean(beanDefinition);
    }


    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return this.beanDefinationMap.get(beanId);
    }

    @Override
    public void registerBeanDefinition(String beanId, BeanDefinition bd) {
        this.beanDefinationMap.put(beanId,bd);
    }

    @Override
    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public ClassLoader getClassLoader() {
        return this.classLoader!=null?this.classLoader:ClassUtils.getDefaultClassLoader();
    }

    private Object createBean(BeanDefinition beanDefinition){
        String beanClassName = beanDefinition.getBeanClassName();
        ClassLoader cl = this.getClassLoader();
        try {
            Class clazz = cl.loadClass(beanClassName);
            return clazz.newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("crate bean for '"+beanClassName+"' exception",e.getMessage());
        }
    }

}
