package com.example.hotelreservation.controllers;

import com.example.hotelreservation.models.Hotel;
import com.example.hotelreservation.services.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/hoteis")
public class HotelController {
    private final HotelService hotelService;

    @GetMapping("/pesquisar")
    public List<Hotel> pesquisarHoteis(@RequestParam String localizacao, @RequestParam int numeroQuartos) {
        return hotelService.pesquisarHoteis(localizacao, numeroQuartos);
    }

    @GetMapping("/comparar")
    public List<Hotel> compararHoteis(
            @RequestParam double precoMinimo,
            @RequestParam double precoMaximo,
            @RequestParam String localizacao) {
        return hotelService.compararHoteis(precoMinimo, precoMaximo, localizacao);
    }
}

