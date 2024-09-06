package com.example.hotelreservation.services;

import com.example.hotelreservation.models.Hotel;
import com.example.hotelreservation.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ComparacaoHotelService {
    private final HotelRepository hotelRepository;

    public ComparacaoHotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> compararPorPreco(String destino) {
        List<Hotel> hoteis = hotelRepository.findByDestino(destino);
        hoteis.sort(Comparator.comparingDouble(Hotel::getPrecoPorNoite));
        return hoteis;
    }

    public List<Hotel> compararPorLocalizacao(String destino) {
        List<Hotel> hoteis = hotelRepository.findByDestino(destino);
        hoteis.sort(Comparator.comparing(Hotel::getLocalizacao));
        return hoteis;
    }

    public List<Hotel> compararPorComodidades(String destino) {
        List<Hotel> hoteis = hotelRepository.findByDestino(destino);
        hoteis.sort(Comparator.comparingInt(h -> h.getComodidades().size()));
        return hoteis;
    }

    public List<Hotel> compararPorAvaliacoes(String destino) {
        List<Hotel> hoteis = hotelRepository.findByDestino(destino);
        hoteis.sort(Comparator.comparingDouble(Hotel::calcularMediaAvaliacoes).reversed());
        return hoteis;
    }
}

