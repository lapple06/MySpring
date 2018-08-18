package org.mySpring.core.io;

import org.mySpring.utils.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ClassPathResource implements Resource {

    private final String path;
    private ClassLoader cl;

    public ClassPathResource(String path){
        this(path,null);
    }

    public ClassPathResource(String path,ClassLoader cl){
        this.path = path;
        this.cl = cl!=null?cl: ClassUtils.getDefaultClassLoader();
    }

    @Override
    public InputStream getInputStream() throws IOException{
        InputStream is = this.cl.getResourceAsStream(this.path);
        if(is==null){
            throw new FileNotFoundException("path "+path+" can't not be open");
        }
        return this.cl.getResourceAsStream(this.path);
    }

    @Override
    public String getDescription() {
        return "class Path:["+this.path+"]";
    }
}
