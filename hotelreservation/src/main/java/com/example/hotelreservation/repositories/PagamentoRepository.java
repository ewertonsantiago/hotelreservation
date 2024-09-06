package com.example.hotelreservation.repositories;

import com.example.hotelreservation.models.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
