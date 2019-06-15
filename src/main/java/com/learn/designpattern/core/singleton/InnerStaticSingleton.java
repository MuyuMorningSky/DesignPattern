package com.learn.designpattern.core.singleton;

public class InnerStaticSingleton {

    private static class InnerSingleton{
        private static final InnerStaticSingleton innerStaticSingleton =  new InnerStaticSingleton();
    }

    private InnerStaticSingleton(){}

    public static InnerStaticSingleton getInstance(){
        return InnerSingleton.innerStaticSingleton;
    }
}
