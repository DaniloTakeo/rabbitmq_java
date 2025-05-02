package com.example.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.rabbitmq.config.RabbitMQConfig;

@Component
public class MensagemConsumer {

    @RabbitListener(queues = RabbitMQConfig.FILA_NOME)
    public void receberMensagem(String mensagem) {
        System.out.println("Mensagem recebida: " + mensagem);
    }
}