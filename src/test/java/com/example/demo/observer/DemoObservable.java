package com.example.demo.observer;

import java.util.Observable;

public class DemoObservable extends Observable {

    @Override
    public void notifyObservers(Object arg) {
        setChanged();
        super.notifyObservers(arg);
    }
}
