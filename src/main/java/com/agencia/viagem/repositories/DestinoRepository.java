package com.agencia.viagem.repositories;

import com.agencia.viagem.models.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long> {
   
    List<Destino> findByNomeContainingIgnoreCase(String nome);
}
