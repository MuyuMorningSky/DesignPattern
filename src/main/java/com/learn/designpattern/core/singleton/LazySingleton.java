package com.learn.designpattern.core.singleton;

public class LazySingleton {

    private static LazySingleton lazySingleton;

    private LazySingleton(){}

    public static synchronized LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
