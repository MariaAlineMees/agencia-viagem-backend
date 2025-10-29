package com.agencia.viagem.services;

import com.agencia.viagem.models.Destino;
import com.agencia.viagem.models.Reserva;
import com.agencia.viagem.repositories.DestinoRepository;
import com.agencia.viagem.repositories.ReservaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final DestinoRepository destinoRepository;

    public ReservaService(ReservaRepository reservaRepository, DestinoRepository destinoRepository) {
        this.reservaRepository = reservaRepository;
        this.destinoRepository = destinoRepository;
    }

    @Transactional(readOnly = true)
    public List<Reserva> buscarTodos() {
        return reservaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Reserva buscarPorId(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada com o ID: " + id));
    }

    public Reserva criar(Reserva reserva) {
        // Validação básica para garantir que o destino existe
        if (reserva.getDestino() != null && reserva.getDestino().getId() != null) {
            Destino destino = destinoRepository.findById(reserva.getDestino().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Destino não encontrado com o ID: " + reserva.getDestino().getId()));
            reserva.setDestino(destino);
        } else {
            throw new IllegalArgumentException("O destino da reserva não pode ser nulo.");
        }
        return reservaRepository.save(reserva);
    }

    public Reserva atualizar(Long id, Reserva reservaAtualizada) {
        Reserva reservaExistente = buscarPorId(id); 

        
        reservaExistente.setNomeCliente(reservaAtualizada.getNomeCliente());
        reservaExistente.setEmail(reservaAtualizada.getEmail());
        reservaExistente.setDataPartida(reservaAtualizada.getDataPartida());
        reservaExistente.setDataRetorno(reservaAtualizada.getDataRetorno());
        reservaExistente.setQuantidadePessoas(reservaAtualizada.getQuantidadePessoas());

        
        if (reservaAtualizada.getDestino() != null && reservaAtualizada.getDestino().getId() != null) {
            Destino novoDestino = destinoRepository.findById(reservaAtualizada.getDestino().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Destino não encontrado com o ID: " + reservaAtualizada.getDestino().getId()));
            reservaExistente.setDestino(novoDestino);
        } else {
            throw new IllegalArgumentException("O destino da reserva não pode ser nulo.");
        }

        return reservaRepository.save(reservaExistente);
    }

    public void deletar(Long id) {
        if (!reservaRepository.existsById(id)) {
            throw new EntityNotFoundException("Reserva não encontrada com o ID: " + id);
        }
        reservaRepository.deleteById(id);
    }
}
