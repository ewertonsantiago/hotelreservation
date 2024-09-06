package com.example.hotelreservation.services;

import com.example.hotelreservation.models.Hotel;
import com.example.hotelreservation.repositories.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    @Cacheable("hoteis")
    public List<Hotel> pesquisarHoteis(String localizacao, int numeroQuartos) {
        return hotelRepository.findByDestinoAndNumeroQuartosDisponiveisGreaterThanEqual(localizacao, numeroQuartos);
    }

    public List<Hotel> compararHoteis(double precoMinimo, double precoMaximo, String localizacao) {
        return hotelRepository.buscarPorPrecoLocalizacao(precoMinimo, precoMaximo, localizacao);
    }
}
