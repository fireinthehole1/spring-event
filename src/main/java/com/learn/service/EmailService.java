package com.learn.service;

import com.learn.event.UserRegisterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author bill
 * @version 1.0
 * @date 2020/11/17 13:52
 * @description
 */
@Service
public class EmailService implements ApplicationListener<UserRegisterEvent> , Ordered {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    @Async
    public void onApplicationEvent(UserRegisterEvent event) {
        logger.info("[onApplicationEvent][给用户({}) 发送邮件]", event.getUsername());
    }

    @Override
    public int getOrder() {
        //指定异步的顺序，值越大，越靠后执行
        return 1;
    }
}
