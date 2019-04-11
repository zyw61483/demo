package com.example.demo.observer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class TestObserver {
    DemoObservable observable = new DemoObservable();

    @Before
    public void before(){
        observable.addObserver(new DemoObserver());
    }

    @Test
    public void test(){
        observable.notifyObservers("123");
    }
}
