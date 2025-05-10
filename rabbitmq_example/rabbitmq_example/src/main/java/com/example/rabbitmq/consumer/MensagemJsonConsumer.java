package com.example.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.rabbitmq.config.RabbitMQConfig;
import com.example.rabbitmq.dto.MensagemDTO;

@Component
public class MensagemJsonConsumer {

    @RabbitListener(queues = RabbitMQConfig.FILA_JSON)
    public void receber(MensagemDTO dto) {
        System.out.println("JSON recebido: " + dto);
    }
}