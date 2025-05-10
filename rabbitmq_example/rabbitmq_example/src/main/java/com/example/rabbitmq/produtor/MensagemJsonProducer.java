package com.example.rabbitmq.produtor;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.rabbitmq.config.RabbitMQConfig;
import com.example.rabbitmq.dto.MensagemDTO;

@Service
public class MensagemJsonProducer {

    private final RabbitTemplate rabbitTemplate;

    public MensagemJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviar(MensagemDTO dto) {
        rabbitTemplate.convertAndSend("", RabbitMQConfig.FILA_JSON, dto);
        System.out.println("JSON enviado: " + dto);
    }
}