package com.example.rabbitmq.consumer.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.rabbitmq.config.RabbitMQTopicConfig;

@Component
public class ConsumerGeral {

    @RabbitListener(queues = RabbitMQTopicConfig.FILA_GERAL)
    public void receber(String msg) {
        System.out.println("Geral: " + msg);
    }
}