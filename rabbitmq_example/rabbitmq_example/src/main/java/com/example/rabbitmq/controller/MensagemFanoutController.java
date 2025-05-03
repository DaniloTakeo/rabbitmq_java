package com.example.rabbitmq.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitmq.produtor.MensagemFanoutProducer;

@RestController
@RequestMapping("/api/fanout")
public class MensagemFanoutController {

    private final MensagemFanoutProducer producer;

    public MensagemFanoutController(MensagemFanoutProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public void enviar(@RequestBody String mensagem) {
        producer.enviar(mensagem);
    }
}