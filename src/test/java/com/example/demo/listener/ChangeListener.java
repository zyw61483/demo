package com.example.demo.listener;

import lombok.extern.slf4j.Slf4j;

import java.util.EventListener;

@Slf4j
public class ChangeListener implements EventListener {
    public void getMsg(DemoMsg demoMsg){
        log.info("修改消息:{}为{}",demoMsg.getContent(),demoMsg.getContent()+" !");
    }
}


