package com.example.hotelreservation.controllers;

import com.example.hotelreservation.models.Reserva;
import com.example.hotelreservation.services.ReservaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@AllArgsConstructor
@RestController
@RequestMapping("/api/reservas")
public class ReservaController {
    private final ReservaService reservaService;

    @PostMapping("/fazer")
    public Reserva fazerReserva(
            @RequestParam Long hotelId,
            @RequestParam Long usuarioId,
            @RequestParam String dataCheckIn,
            @RequestParam String dataCheckOut,
            @RequestParam Long quartoId,
            @RequestParam Long pagamentoId) throws Exception {

        var checkIn = LocalDate.parse(dataCheckIn);
        var checkOut = LocalDate.parse(dataCheckOut);

        return reservaService.fazerReserva(hotelId, usuarioId, checkIn, checkOut, quartoId, pagamentoId);
    }
}

