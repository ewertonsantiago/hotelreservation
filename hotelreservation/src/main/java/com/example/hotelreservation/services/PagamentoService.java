package com.example.hotelreservation.services;

import com.example.hotelreservation.models.Pagamento;
import com.example.hotelreservation.repositories.PagamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;

    public Pagamento criarFormaPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }
}
