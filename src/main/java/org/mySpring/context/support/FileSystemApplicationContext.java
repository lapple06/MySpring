package org.mySpring.context.support;

import org.mySpring.core.io.FileSystemResource;
import org.mySpring.core.io.Resource;

public class FileSystemApplicationContext extends AbstractApplicationContext {


    public FileSystemApplicationContext(String configLocation) {
        super(configLocation);
    }

    @Override
    public Resource getResourceByPath(String path) {
        return new FileSystemResource(path);
    }
}
