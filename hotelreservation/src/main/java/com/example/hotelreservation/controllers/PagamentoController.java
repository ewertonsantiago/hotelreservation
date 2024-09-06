package com.example.hotelreservation.controllers;

import com.example.hotelreservation.models.Pagamento;
import com.example.hotelreservation.services.PagamentoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class PagamentoController {
    private final PagamentoService pagamentoService;

    @PostMapping("/pagamento")
    public Pagamento criarFormaPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoService.criarFormaPagamento(pagamento);
    }
}
