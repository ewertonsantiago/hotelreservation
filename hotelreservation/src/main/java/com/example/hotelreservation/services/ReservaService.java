package com.example.hotelreservation.services;

import com.example.hotelreservation.models.Reserva;
import com.example.hotelreservation.models.StatusReservaEnum;
import com.example.hotelreservation.repositories.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final HotelRepository hotelRepository;
    private final UsuarioRepository usuarioRepository;
    private final QuartoRepository quartoRepository;
    private final PagamentoRepository pagamentoRepository;
    private final NotificacaoService notificacaoService;

    @Transactional
    public Reserva fazerReserva(Long hotelId, Long usuarioId, LocalDate dataCheckIn,
                                LocalDate dataCheckOut, Long quartoId, Long pagamentoId) throws Exception {
        var hotelOpt = hotelRepository.findById(hotelId);
        var quartoOpt = quartoRepository.findById(quartoId);
        var usuarioOpt = usuarioRepository.findById(usuarioId);
        var pagamentoOpt = pagamentoRepository.findById(pagamentoId);

        if (hotelOpt.isEmpty()) {
            throw new IllegalArgumentException("Hotel não encontrado");
        }

        if (quartoOpt.isEmpty()) {
            throw new IllegalArgumentException("Quarto não encontrado");
        }

        if (usuarioOpt.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }

        if (pagamentoOpt.isEmpty()) {
            throw new IllegalArgumentException("Forma de Pgamento não encontrado");
        }

        var hotel = hotelOpt.get();
        var pagamento = pagamentoOpt.get();
        var quarto = quartoOpt.get();
        var usuario = usuarioOpt.get();

        if (!hotel.verificarDisponibilidade(hotel.getNumeroQuartos())) {
            throw new Exception("Número de quartos indisponíveis.");
        }

        var reserva = Reserva.builder()
                .hotel(hotel)
                .usuario(usuario)
                .dataCheckIn(dataCheckIn)
                .dataCheckOut(dataCheckOut)
                .quarto(quarto)
                .pagamento(pagamento)
                .status(StatusReservaEnum.CONFIRMADA)
                .build();

        reservaRepository.save(reserva);
        notificacaoService.enviarNotificacaoReservaConfirmada("Reserva Confirmada");
        return reserva;
    }
}
