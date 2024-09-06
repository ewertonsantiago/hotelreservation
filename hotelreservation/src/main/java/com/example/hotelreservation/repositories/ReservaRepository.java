package com.example.hotelreservation.repositories;

import com.example.hotelreservation.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
