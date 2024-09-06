package com.example.hotelreservation.controllers;

import com.example.hotelreservation.models.Hotel;
import com.example.hotelreservation.services.PesquisaHotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class PesquisaHotelController {
    private final PesquisaHotelService pesquisaHotelService;

    public PesquisaHotelController(PesquisaHotelService pesquisaHotelService) {
        this.pesquisaHotelService = pesquisaHotelService;
    }

    @GetMapping("/hoteis/pesquisar")
    public List<Hotel> pesquisarHoteis(
            @RequestParam String destino,
            @RequestParam LocalDate checkIn,
            @RequestParam LocalDate checkOut,
            @RequestParam int numeroQuartos) {
        return pesquisaHotelService.buscarHoteis(destino, checkIn, checkOut, numeroQuartos);
    }
}

