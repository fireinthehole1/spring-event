package com.learn.service;

import com.learn.event.UserRegisterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author bill
 * @version 1.0
 * @date 2020/11/17 13:54
 * @description
 */
@Service
public class CouponService implements ApplicationListener<UserRegisterEvent> , Ordered {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    @Async
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        logger.info("onApplicationEvent给用户({})发送优惠券",userRegisterEvent.getUsername());
    }

    @Override
    public int getOrder() {
        //指定异步执行优先级
        return 0;
    }
}
