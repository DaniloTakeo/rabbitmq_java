package com.example.rabbitmq.consumer.headers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.rabbitmq.config.RabbitMQHeadersConfig;

@Component
public class ConsumerAdmin {

    @RabbitListener(queues = RabbitMQHeadersConfig.FILA_ADMIN)
    public void receber(String msg) {
        System.out.println("Admin: " + msg);
    }
}