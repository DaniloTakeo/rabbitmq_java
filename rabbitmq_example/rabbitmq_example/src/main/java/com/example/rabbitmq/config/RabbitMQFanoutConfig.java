package com.example.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQFanoutConfig {

    public static final String FANOUT_EXCHANGE = "exemplo.fanout";
    public static final String FILA_1 = "fila.fanout.1";
    public static final String FILA_2 = "fila.fanout.2";

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Queue fila1() {
        return new Queue(FILA_1, true);
    }

    @Bean
    public Queue fila2() {
        return new Queue(FILA_2, true);
    }

    @Bean
    public Binding binding1(FanoutExchange fanoutExchange, Queue fila1) {
        return BindingBuilder.bind(fila1).to(fanoutExchange);
    }

    @Bean
    public Binding binding2(FanoutExchange fanoutExchange, Queue fila2) {
        return BindingBuilder.bind(fila2).to(fanoutExchange);
    }
}