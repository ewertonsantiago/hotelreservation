package com.example.hotelreservation.repositories;

import com.example.hotelreservation.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query("SELECT h FROM Hotel h WHERE h.localizacao = :destino AND h.numeroQuartos >= :numeroQuartos")
    List<Hotel> findByDestinoAndNumeroQuartosDisponiveisGreaterThanEqual(
            @Param("localizacao") String localizacao, @Param("numeroQuartos") int numeroQuartos);

    @Query("SELECT h FROM Hotel h WHERE h.destino = :destino")
    List<Hotel> findByDestino(@Param("destino") String destino);

    @Query("SELECT h FROM Hotel h WHERE h.precoPorNoite BETWEEN :precoMinimo AND :precoMaximo " +
            "AND h.destino LIKE %:localizacao%")
    List<Hotel> buscarPorPrecoLocalizacao(@Param("precoMinimo") double precoMinimo,
                                          @Param("precoMaximo") double precoMaximo,
                                          @Param("localizacao") String localizacao);

    @Query("SELECT h FROM Hotel h " +
            " JOIN Reserva r ON r.hotel.id = h.id" +
            " WHERE h.localizacao = :destino AND h.numeroQuartos >= :numeroQuartos " +
            " AND r.dataCheckIn = : checkIn AND r.dataCheckOut = :checkOut")
    List<Hotel> findByDestinoAndCheck(
            @Param("destino") String localizacao,
            @Param("checkIn")LocalDate checkIn,
            @Param("checkOut")LocalDate checkOut,
            @Param("numeroQuartos") int numeroQuartos);
}
