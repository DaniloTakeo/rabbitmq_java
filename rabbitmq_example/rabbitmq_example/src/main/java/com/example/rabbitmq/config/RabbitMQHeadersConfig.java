package com.example.rabbitmq.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQHeadersConfig {

    public static final String HEADERS_EXCHANGE = "exemplo.headers";

    public static final String FILA_ADMIN = "fila.admin";
    public static final String FILA_SUPORTE = "fila.suporte";

    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange(HEADERS_EXCHANGE);
    }

    @Bean
    public Queue filaAdmin() {
        return new Queue(FILA_ADMIN, true);
    }

    @Bean
    public Queue filaSuporte() {
        return new Queue(FILA_SUPORTE, true);
    }

    @Bean
    public Binding bindingAdmin() {
        Map<String, Object> headers = new HashMap<>();
        headers.put("tipo", "admin");

        return BindingBuilder
                .bind(filaAdmin())
                .to(headersExchange())
                .whereAll(headers)
                .match();
    }

    @Bean
    public Binding bindingSuporte() {
        Map<String, Object> headers = new HashMap<>();
        headers.put("setor", "support");
        headers.put("nivel", "1");

        return BindingBuilder
                .bind(filaSuporte())
                .to(headersExchange())
                .whereAll(headers)
                .match();
    }
}