package com.example.hotelreservation.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String destino;
    private double precoPorNoite;
    private int numeroQuartos;
    private String localizacao;

    @ElementCollection
    private List<String> comodidades;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Avaliacao> avaliacoes;

    public double calcularMediaAvaliacoes() {
        return avaliacoes.stream().mapToDouble(Avaliacao::getNota).average().orElse(0.0);
    }

    public boolean verificarDisponibilidade(int numeroQuartos) {
        return this.numeroQuartos >= numeroQuartos;
    }
}
