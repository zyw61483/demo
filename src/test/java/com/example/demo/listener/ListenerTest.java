package com.example.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class ListenerTest {

    DemoMsg msg;

    @Before
    public void before(){
        msg = new DemoMsg();
        msg.setListener(new DemoListener());
        msg.setListener(new ChangeListener());
    }

    @Test
    public void test(){
        msg.send("hello");
    }
}
