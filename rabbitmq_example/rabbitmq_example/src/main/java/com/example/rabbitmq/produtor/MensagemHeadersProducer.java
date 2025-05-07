package com.example.rabbitmq.produtor;

import java.util.Map;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.rabbitmq.config.RabbitMQHeadersConfig;

@Service
public class MensagemHeadersProducer {

    private final RabbitTemplate rabbitTemplate;

    public MensagemHeadersProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviar(Map<String, Object> headers, String mensagem) {
        Message message = MessageBuilder
                .withBody(mensagem.getBytes())
                .setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
                .copyHeaders(headers)
                .build();

        rabbitTemplate.send(RabbitMQHeadersConfig.HEADERS_EXCHANGE, "", message);
        System.out.println("Mensagem enviada com headers: " + headers);
    }
}