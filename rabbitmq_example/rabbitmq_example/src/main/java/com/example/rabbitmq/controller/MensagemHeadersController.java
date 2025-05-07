package com.example.rabbitmq.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitmq.produtor.MensagemHeadersProducer;

@RestController
@RequestMapping("/api/headers")
public class MensagemHeadersController {

    private final MensagemHeadersProducer producer;

    public MensagemHeadersController(MensagemHeadersProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public void enviar(@RequestBody Map<String, Object> body) {
        String mensagem = (String) body.get("mensagem");
        Map<String, Object> headers = (Map<String, Object>) body.get("headers");
        producer.enviar(headers, mensagem);
    }
}