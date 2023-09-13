package ir.neshan.myspringapplication.service;

import ir.neshan.myspringapplication.config.MQConfig;
import ir.neshan.myspringapplication.dto.GlobalMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {
    @RabbitListener(queues = MQConfig.QUEUE1)
    public void consumeMessageFromQueue1(GlobalMessage globalMessage) {
        System.out.println("Received message from queue1: " + globalMessage);
    }

    @RabbitListener(queues = MQConfig.QUEUE2)
    public void consumeMessageFromQueue2(GlobalMessage globalMessage) {
        System.out.println("Received message from queue2: " + globalMessage);
    }
}
