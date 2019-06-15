package com.learn.designpattern.core.singleton;

public class FullSingleton {

    private static FullSingleton fullSingleton;

    private FullSingleton(){}

    public static synchronized FullSingleton getInstance() {
        if (fullSingleton == null) {
            fullSingleton = new FullSingleton();
        }
        return fullSingleton;
    }
}
