package com.common.generate.javacreate.service.mq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MQService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MQService.class);
	@Autowired
	private RabbitTemplate rabbittemplate;
	@Autowired
	private ObjectMapper jsonObject;


	public void test(String json) {
		try {
			this.rabbittemplate.convertAndSend("ex.test.add", null, json);
		} catch (Exception ex) {

		}
	}


}
