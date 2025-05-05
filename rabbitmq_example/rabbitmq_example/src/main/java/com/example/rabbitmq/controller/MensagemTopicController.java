package com.example.rabbitmq.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitmq.produtor.MensagemTopicProducer;

@RestController
@RequestMapping("/api/topic")
public class MensagemTopicController {

    private final MensagemTopicProducer producer;

    public MensagemTopicController(MensagemTopicProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public void enviar(
            @RequestParam String routingKey,
            @RequestBody String mensagem) {
        producer.enviar(routingKey, mensagem);
    }
}