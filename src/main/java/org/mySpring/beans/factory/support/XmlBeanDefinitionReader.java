package org.mySpring.beans.factory.support;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.mySpring.beans.BeanDefinition;
import org.mySpring.beans.factory.BeanDefinitionStoreException;
import org.mySpring.core.io.Resource;
import org.mySpring.utils.ClassUtils;

import java.io.InputStream;
import java.util.Iterator;

public class XmlBeanDefinitionReader {

    private BeanDefinitionRegistry beanDefinitionRegistry;

    public static final String ID_ATTRIBUTE = "id";
    public static final String CLASS_ATTRIBUTE = "class";
    public static final String SCOPE_ATTRIBUTE = "scope";

    public XmlBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry){
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    public void loadBeanDefination(Resource resource){
        try{
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read(resource.getInputStream());
            Element rootEle = doc.getRootElement();
            Iterator<Element> iter = rootEle.elementIterator();
            while(iter.hasNext()){
                Element ele = iter.next();
                String id = ele.attributeValue(ID_ATTRIBUTE);
                String className = ele.attributeValue(CLASS_ATTRIBUTE);
                String scope = ele.attributeValue(SCOPE_ATTRIBUTE);
                BeanDefinition bd = new GenericBeanDefinition(id,className);
                if(scope!=null){
                    bd.setScope(scope);
                }
                this.beanDefinitionRegistry.registerBeanDefinition(id,bd);
            }
        } catch (Exception e) {
            throw new BeanDefinitionStoreException("error create bean defination",e);
        }

    }



}
