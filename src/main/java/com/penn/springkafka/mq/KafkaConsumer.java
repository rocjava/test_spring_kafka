package com.penn.springkafka.mq;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.Logger;
import org.springframework.kafka.listener.MessageListener;

public class KafkaConsumer implements MessageListener<String, String> {

    final Logger logger = Logger.getLogger(KafkaConsumer.class);

    @Override
    public void onMessage(ConsumerRecord<String, String> record) {
        logger.info("-------------topic:"+record.topic());
        logger.info("-------------value:"+record.value());
        logger.info("-------------key:"+record.key());
        logger.info("-------------offset:"+record.offset());
        logger.info("-------------partition:"+record.partition());
        logger.info("==========kafka消费结束===============");
    }
}
