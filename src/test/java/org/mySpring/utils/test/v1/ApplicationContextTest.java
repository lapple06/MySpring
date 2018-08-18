package org.mySpring.utils.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.mySpring.context.ApplicationContext;
import org.mySpring.context.support.ClassPathXmlApplicationContext;
import org.mySpring.context.support.FileSystemApplicationContext;
import org.mySpring.test.service.v1.PetStoreService;

public class ApplicationContextTest {

    @Test
    public void testClassPathXmlApplicationContext(){
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("petStore-v1.xml");
        PetStoreService service = (PetStoreService) ctx.getBean("petStoreService");
        Assert.assertNotNull(service);
    }

    @Test
    public void testFileSystemApplicationContext(){
        ApplicationContext ctx
                = new FileSystemApplicationContext("F:\\java\\MySpring\\src\\test\\resources\\petStore-v1.xml");
        PetStoreService service = (PetStoreService) ctx.getBean("petStoreService");
        Assert.assertNotNull(service);
    }


}
