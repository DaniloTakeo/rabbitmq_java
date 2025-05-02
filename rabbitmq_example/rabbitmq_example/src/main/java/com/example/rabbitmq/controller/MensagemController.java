package com.example.rabbitmq.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitmq.produtor.MensagemProducer;

@RestController
@RequestMapping("/api/mensagens")
public class MensagemController {

    private final MensagemProducer producer;

    public MensagemController(MensagemProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public void enviar(@RequestBody String mensagem) {
        producer.enviarMensagem(mensagem);
    }
}