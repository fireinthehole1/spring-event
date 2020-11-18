package com.learn.service;

import com.learn.event.UserRegisterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author bill
 * @version 1.0
 * @date 2020/11/17 12:00
 * @description
 */
@Service
public class UserEventService implements ApplicationEventPublisherAware {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
         this.applicationEventPublisher=applicationEventPublisher;
    }

    public void register(String username) {
        logger.info("[register][执行用户({}) 的注册逻辑]", username);
        applicationEventPublisher.publishEvent(new UserRegisterEvent(this, username));
    }
}
