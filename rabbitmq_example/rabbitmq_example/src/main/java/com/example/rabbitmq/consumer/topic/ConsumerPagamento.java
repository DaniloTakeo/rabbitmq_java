package com.example.rabbitmq.consumer.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.rabbitmq.config.RabbitMQTopicConfig;

@Component
public class ConsumerPagamento {

    @RabbitListener(queues = RabbitMQTopicConfig.FILA_PAGAMENTO)
    public void receber(String msg) {
        System.out.println("Pagamento: " + msg);
    }
}