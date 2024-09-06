package com.example.hotelreservation.services;

import com.example.hotelreservation.models.Hotel;
import com.example.hotelreservation.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class PesquisaHotelService {
    private final HotelRepository hotelRepository;

    public PesquisaHotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> buscarHoteis(String destino, LocalDate checkIn, LocalDate checkOut, int numeroQuartos) {
        return hotelRepository.findByDestinoAndCheck(destino, checkIn, checkOut, numeroQuartos);
    }
}

