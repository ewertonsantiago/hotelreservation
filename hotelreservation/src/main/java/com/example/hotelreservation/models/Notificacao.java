package com.example.hotelreservation.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destinatario;
    private String mensagem;
    private String status;
    private LocalDate dataEnvio;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

}

