package com.example.rabbitmq.produtor;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.rabbitmq.config.RabbitMQTopicConfig;

@Service
public class MensagemTopicProducer {

    private final RabbitTemplate rabbitTemplate;

    public MensagemTopicProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviar(String routingKey, String mensagem) {
        rabbitTemplate.convertAndSend(RabbitMQTopicConfig.TOPIC_EXCHANGE, routingKey, mensagem);
        System.out.printf("Mensagem enviada com routing key [%s]: %s%n", routingKey, mensagem);
    }
}