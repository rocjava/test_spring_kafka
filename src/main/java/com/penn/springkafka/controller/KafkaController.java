package com.penn.springkafka.controller;

import com.penn.springkafka.mq.KafkaProducer;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class KafkaController {

    final Logger logger = Logger.getLogger(KafkaController.class);

    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping("/send")
    public String index(String topic) {
        if(topic == null){
            return "topic不可为空";//order_test_topic or other_test_topic
        }
        String value = "test";
        String ifPartition = "0";
        Integer partitionNum = 1;
        String role = "test";//用来生成key
        Map<String,Object> res = kafkaProducer.sndMesForTemplate
                (topic, value, ifPartition, partitionNum, role);

        String message = (String)res.get("message");
        String code = (String)res.get("code");

        logger.info("--->发送结果code:"+code);
        logger.info("--->发送结果message:"+message);

        return "index";
    }

}
