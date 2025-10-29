package com.agencia.viagem.repositories;

import com.agencia.viagem.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Busca reservas cujo nome do cliente contenha a string fornecida, ignorando maiúsculas/minúsculas.
    List<Reserva> findByNomeClienteContainingIgnoreCase(String nomeCliente);
}
