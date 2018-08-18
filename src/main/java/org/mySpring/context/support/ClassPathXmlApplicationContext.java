package org.mySpring.context.support;

import org.mySpring.core.io.ClassPathResource;
import org.mySpring.core.io.Resource;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {


    public ClassPathXmlApplicationContext(String configLocation) {
        super(configLocation);
    }


    @Override
    public Resource getResourceByPath(String path) {
        return new ClassPathResource(path);
    }

}
