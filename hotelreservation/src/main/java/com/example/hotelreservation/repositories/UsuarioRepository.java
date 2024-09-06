package com.example.hotelreservation.repositories;

import com.example.hotelreservation.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
