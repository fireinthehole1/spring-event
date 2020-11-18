package com.learn.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author bill
 * @version 1.0
 * @date 2020/11/17 11:58
 * @description 定义一个事件
 */
public class UserRegisterEvent extends ApplicationEvent {

    private String username;

    public UserRegisterEvent(Object source) {
        super(source);
    }

    public UserRegisterEvent(Object source, String username) {
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
