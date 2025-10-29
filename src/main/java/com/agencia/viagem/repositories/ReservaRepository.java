package com.agencia.viagem.repositories;

import com.agencia.viagem.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
    List<Reserva> findByNomeClienteContainingIgnoreCase(String nomeCliente);
}
