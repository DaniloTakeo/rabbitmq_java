package com.example.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {

    public static final String TOPIC_EXCHANGE = "exemplo.topic";

    public static final String FILA_GERAL = "fila.geral";
    public static final String FILA_CLIENTE = "fila.cliente";
    public static final String FILA_PAGAMENTO = "fila.pagamento";

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Queue filaGeral() {
        return new Queue(FILA_GERAL, true);
    }

    @Bean
    public Queue filaCliente() {
        return new Queue(FILA_CLIENTE, true);
    }

    @Bean
    public Queue filaPagamento() {
        return new Queue(FILA_PAGAMENTO, true);
    }

    @Bean
    public Binding bindingGeral() {
        return BindingBuilder
                .bind(filaGeral())
                .to(topicExchange())
                .with("#");
    }

    @Bean
    public Binding bindingCliente() {
        return BindingBuilder
                .bind(filaCliente())
                .to(topicExchange())
                .with("cliente.*");
    }

    @Bean
    public Binding bindingPagamento() {
        return BindingBuilder
                .bind(filaPagamento())
                .to(topicExchange())
                .with("*.pagamento.*");
    }
}

