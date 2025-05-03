package com.example.rabbitmq.produtor;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.rabbitmq.config.RabbitMQFanoutConfig;

@Service
public class MensagemFanoutProducer {

    private final RabbitTemplate rabbitTemplate;

    public MensagemFanoutProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviar(String mensagem) {
        rabbitTemplate.convertAndSend(RabbitMQFanoutConfig.FANOUT_EXCHANGE, "", mensagem);
        System.out.println("Mensagem enviada para exchange fanout: " + mensagem);
    }
}