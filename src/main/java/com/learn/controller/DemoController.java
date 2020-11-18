package com.learn.controller;

import com.learn.service.UserEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author bill
 * @version 1.0
 * @date 2020/11/17 13:56
 * @description
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserEventService userEventService;

    @GetMapping("/register")
    public String register(String username) {
        logger.info("接收用户[{}]注册事件",username);
        userEventService.register(username);
        return "success";
    }
}
