package com.example.hotelreservation.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoConsumer {

    @KafkaListener(topics = "notificacoes", groupId = "grupo_reservas")
    public void processarNotificacao(String mensagem) {
        System.out.println("Notificação recebida: " + mensagem);
    }
}

