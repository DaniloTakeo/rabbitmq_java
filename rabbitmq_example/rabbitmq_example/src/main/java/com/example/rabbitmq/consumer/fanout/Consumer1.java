package com.example.rabbitmq.consumer.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.rabbitmq.config.RabbitMQFanoutConfig;

@Component
public class Consumer1 {

    @RabbitListener(queues = RabbitMQFanoutConfig.FILA_1)
    public void consumir(String mensagem) {
        System.out.println("Consumer 1 recebeu: " + mensagem);
    }
}