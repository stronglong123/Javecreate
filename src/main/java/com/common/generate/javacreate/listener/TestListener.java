package com.common.generate.javacreate.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 * @author xialei
 * @date 2020/6/9 10:28
 */
@Service
public class TestListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestListener.class);

    /**
     * 同步调拨出库单状态
     *
     * @param message
     */
    @RabbitListener(queues = "mq.test.add")
    public void outStockUpdateState(Message message) {
        String json = new String(message.getBody(), StandardCharsets.UTF_8);
        LOGGER.info("接收消息：{}", json);
    }

}
