package org.mySpring.core.io;

import org.mySpring.utils.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileSystemResource implements Resource{

    private final String path;

    public FileSystemResource(String path){
        Assert.notNull(path,"file path must not be null");
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException{
        InputStream is = new FileInputStream(path);
        return is;
    }

    @Override
    public String getDescription() {
        return "file ["+this.path+"]";
    }
}
