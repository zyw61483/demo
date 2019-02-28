package com.example.demo.listener;

import lombok.extern.slf4j.Slf4j;

import java.util.EventListener;

@Slf4j
public class DemoListener implements EventListener {
    public void getMsg(DemoMsg demoMsg){
        log.info("监听到一条消息:{}",demoMsg.getContent());
    }
}


