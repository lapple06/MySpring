package org.mySpring.utils.test.v1;


import jdk.internal.util.xml.impl.Input;
import org.junit.Assert;
import org.junit.Test;
import org.mySpring.core.io.ClassPathResource;
import org.mySpring.core.io.FileSystemResource;
import org.mySpring.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

public class ResourceTest {

    @Test
    public void testClassPathResource() throws IOException {
        Resource resource = new ClassPathResource("petStore-v1.xml");
        InputStream is = resource.getInputStream();
        Assert.assertNotNull(is);
    }

    @Test
    public void testFileSystemResource() throws IOException {
        Resource resource = new FileSystemResource("F:\\java\\MySpring\\src\\test\\resources\\petStore-v1.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);
    }


}
