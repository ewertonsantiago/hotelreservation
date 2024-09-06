package com.example.hotelreservation.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "quarto_id")
    private Quarto quarto;

    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;

    @Enumerated(EnumType.STRING)
    private StatusReservaEnum status;

    @ManyToOne
    @JoinColumn(name = "pagamento_id")
    private Pagamento pagamento;
}

