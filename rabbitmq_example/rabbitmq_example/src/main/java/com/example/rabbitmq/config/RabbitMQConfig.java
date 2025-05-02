package com.example.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FILA_NOME = "fila.exemplo";

    @Bean
    public Queue filaExemplo() {
        return new Queue(FILA_NOME, true);
    }
}