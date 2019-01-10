package com.penn.springkafka.mq;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.log4j.Logger;
import org.springframework.kafka.support.ProducerListener;

/**
 * Created by Administrator on 2019/1/9.
 */
public class KafkaProducerListener implements ProducerListener {

    final Logger logger = Logger.getLogger(KafkaProducerListener.class);

    @Override
    public void onSuccess(String topic, Integer partition, Object key, Object value, RecordMetadata recordMetadata) {
        logger.info("----------topic:"+topic);
        logger.info("----------partition:"+partition);
        logger.info("----------key:"+key);
        logger.info("----------value:"+value);
        logger.info("----------RecordMetadata:"+recordMetadata);
        logger.info("==========kafka发送数据成功===============");
    }

    @Override
    public void onError(String topic, Integer partition, Object key, Object value, Exception e) {
        logger.info("----------topic:"+topic);
        logger.info("----------partition:"+partition);
        logger.info("----------key:"+key);
        logger.info("----------value:"+value);
        logger.info("----------Exception:"+e);
        logger.info("==========kafka发送数据失败===============");
        e.printStackTrace();
    }

    @Override
    public boolean isInterestedInSuccess() {
        logger.info("==========kafka监听器启动成功==============");
        return true;
    }
}
