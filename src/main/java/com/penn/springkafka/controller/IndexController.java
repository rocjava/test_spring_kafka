package com.penn.springkafka.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by Administrator on 2019/1/2.
 */
@Controller
public class IndexController {
    final Logger logger = Logger.getLogger(IndexController.class);
    @Autowired
    private App app;
    @RequestMapping("/home")
    public String index() {
        return "index";
    }

    @RequestMapping("/greeting")
    public ModelAndView greeting(ModelAndView modelView) {
        logger.info("greeting request is coming.");
        modelView.addObject("greeting", app.sayHello());
        modelView.setViewName("greeting");
        return modelView;
    }
}
