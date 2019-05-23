package com.learn.designpattern.core.observer.jdk;


import java.util.Observable;

public class MessageObservable extends Observable {

    @Override
    public void notifyObservers(Object message) {
        setChanged();
        super.notifyObservers(message);
    }
}
