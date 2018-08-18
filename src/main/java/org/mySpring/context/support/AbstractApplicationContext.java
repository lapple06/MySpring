package org.mySpring.context.support;

import org.mySpring.beans.factory.support.DefaultBeanFactory;
import org.mySpring.beans.factory.support.XmlBeanDefinitionReader;
import org.mySpring.context.ApplicationContext;
import org.mySpring.core.io.Resource;
import org.mySpring.utils.ClassUtils;

public abstract class AbstractApplicationContext implements ApplicationContext {

    private DefaultBeanFactory beanFactory;

    private ClassLoader classLoader;

    public AbstractApplicationContext(String configLocation){
        beanFactory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        Resource resource = this.getResourceByPath(configLocation);
        reader.loadBeanDefination(resource);
        beanFactory.setClassLoader(this.getClassLoader());
    }

    @Override
    public Object getBean(String beanId) {
        return beanFactory.getBean(beanId);
    }

    public abstract Resource getResourceByPath(String path);

    @Override
    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public ClassLoader getClassLoader() {
        return this.classLoader!=null?this.classLoader: ClassUtils.getDefaultClassLoader();
    }

}
