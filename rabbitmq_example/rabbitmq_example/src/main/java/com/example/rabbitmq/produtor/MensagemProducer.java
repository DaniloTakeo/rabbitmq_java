package com.example.rabbitmq.produtor;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.rabbitmq.config.RabbitMQConfig;

@Service
public class MensagemProducer {

    private final RabbitTemplate rabbitTemplate;

    public MensagemProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarMensagem(String mensagem) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.FILA_NOME, mensagem);
        System.out.println("Mensagem enviada: " + mensagem);
    }
}