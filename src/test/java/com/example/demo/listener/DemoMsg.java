package com.example.demo.listener;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.EventListener;
import java.util.List;

@Data
@Slf4j
public class DemoMsg {
    private long id;
    private String content;
    private List<EventListener> listeners= Lists.newArrayList();

    public void setListener(EventListener listener) {
        listeners.add(listener);
    }

    public void send(String msg) {
        this.content = msg;
        log.info("发送一条消息:{}", msg);
        for (EventListener listener : listeners) {
            if(listener instanceof DemoListener) {
                DemoListener demoListener = (DemoListener) listener;
                demoListener.getMsg(this);
            }else if(listener instanceof ChangeListener){
                ChangeListener changeListener = (ChangeListener) listener;
                changeListener.getMsg(this);
            }
        }
    }
}