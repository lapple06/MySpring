package org.mySpring.utils.test.v1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mySpring.beans.factory.BeanDefinitionStoreException;
import org.mySpring.beans.factory.support.XmlBeanDefinitionReader;
import org.mySpring.core.io.ClassPathResource;
import org.mySpring.core.io.Resource;
import org.mySpring.test.service.v1.PetStoreService;
import org.mySpring.beans.BeanDefinition;
import org.mySpring.beans.factory.BeanFactory;
import org.mySpring.beans.factory.support.DefaultBeanFactory;

public class BeanFactoryTest {

    private DefaultBeanFactory beanFactory;
    private XmlBeanDefinitionReader reader;

    @Before
    public void setUp(){
        beanFactory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(beanFactory);
        Resource resource = new ClassPathResource("petStore-v1.xml");
        reader.loadBeanDefination(resource);
    }


    @Test
    public void testBean(){
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("petStoreService");
        Assert.assertEquals(BeanDefinition.SCOPE_DEFAULT,beanDefinition.getScope());
        Assert.assertEquals(true,beanDefinition.isSingleton());

        Assert.assertEquals("org.mySpring.test.service.v1.PetStoreService"
                , beanDefinition.getBeanClassName());

        PetStoreService petStoreService = (PetStoreService) beanFactory.getBean("petStoreService");
        Assert.assertNotNull(petStoreService);

        PetStoreService petStoreService1 = (PetStoreService) beanFactory.getBean("petStoreService");
        Assert.assertEquals(petStoreService,petStoreService1);

    }

    @Test
    public void testBeanCreationException(){
        try{
            PetStoreService petStoreService = (PetStoreService) beanFactory.getBean("invalidBean");
        }catch (Exception e){
            return;
        }
        Assert.fail();
    }


}
