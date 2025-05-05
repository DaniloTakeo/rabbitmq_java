package com.example.rabbitmq.consumer.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.rabbitmq.config.RabbitMQTopicConfig;

@Component
public class ConsumerCliente {

    @RabbitListener(queues = RabbitMQTopicConfig.FILA_CLIENTE)
    public void receber(String msg) {
        System.out.println("Cliente: " + msg);
    }
}