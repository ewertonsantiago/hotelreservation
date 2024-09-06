package com.example.hotelreservation.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comentario;
    private int nota;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}

