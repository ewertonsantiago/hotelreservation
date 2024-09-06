package com.example.hotelreservation.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public NotificacaoService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarNotificacaoReservaConfirmada(String mensagem) {
        var TOPIC = "notificacoes";
        kafkaTemplate.send(TOPIC, mensagem);
    }
}
