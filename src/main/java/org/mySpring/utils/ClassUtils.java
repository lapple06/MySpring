package org.mySpring.utils;

public abstract class ClassUtils{

    public static ClassLoader getDefaultClassLoader(){
        ClassLoader cl = null;
        try{
            cl = Thread.currentThread().getContextClassLoader();
        }catch(Throwable ex){
            //获取不到当前线程的classLoader，进行降级
            //捕获异常不进行处理，主要防止抛出异常线程结束
        }

        if(cl==null){
            cl = ClassUtils.class.getClassLoader();

        }
        return cl;
    }

}
