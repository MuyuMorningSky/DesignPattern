package com.learn.designpattern.core.singleton;

public class HungerSingleton {

    private static HungerSingleton hungerSingleton = new HungerSingleton();

    private HungerSingleton(){}

    public static HungerSingleton getInstance() {
        return hungerSingleton;
    }
}
