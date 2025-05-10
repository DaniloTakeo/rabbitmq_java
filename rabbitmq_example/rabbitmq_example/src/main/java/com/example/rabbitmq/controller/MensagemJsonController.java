package com.example.rabbitmq.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitmq.dto.MensagemDTO;
import com.example.rabbitmq.produtor.MensagemJsonProducer;

@RestController
@RequestMapping("/api/json")
public class MensagemJsonController {

    private final MensagemJsonProducer producer;

    public MensagemJsonController(MensagemJsonProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public void enviar(@RequestBody MensagemDTO dto) {
        producer.enviar(dto);
    }
}