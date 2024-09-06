package com.example.hotelreservation.controllers;

import com.example.hotelreservation.models.Hotel;
import com.example.hotelreservation.services.ComparacaoHotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comparacao")
public class ComparacaoHotelController {
    private final ComparacaoHotelService comparacaoHotelService;

    public ComparacaoHotelController(ComparacaoHotelService comparacaoHotelService) {
        this.comparacaoHotelService = comparacaoHotelService;
    }

    @GetMapping("/preco")
    public List<Hotel> compararPorPreco(@RequestParam String destino) {
        return comparacaoHotelService.compararPorPreco(destino);
    }

    @GetMapping("/localizacao")
    public List<Hotel> compararPorLocalizacao(@RequestParam String destino) {
        return comparacaoHotelService.compararPorLocalizacao(destino);
    }

    @GetMapping("/comodidades")
    public List<Hotel> compararPorComodidades(@RequestParam String destino) {
        return comparacaoHotelService.compararPorComodidades(destino);
    }

    @GetMapping("/avaliacoes")
    public List<Hotel> compararPorAvaliacoes(@RequestParam String destino) {
        return comparacaoHotelService.compararPorAvaliacoes(destino);
    }
}

