package cn.mldn.microboot.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import cn.mldn.microboot.config.ConsumerConfig;

@Service
public class MessageConsumerService {
	@RabbitListener(queues = ConsumerConfig.QUEUE_NAME)
	public void receiveMessage(String text) {	// 进行消息的接受处理
		System.err.println("【*** 接受到消息 ***】" + text);
	}
}
