package com.agencia.viagem.services;

import com.agencia.viagem.dtos.AuthenticationDTO;
import com.agencia.viagem.models.Destino;
import com.agencia.viagem.repositories.DestinoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DestinoService {


    private final DestinoRepository destinoRepository;

    public DestinoService(DestinoRepository destinoRepository) {
        this.destinoRepository = destinoRepository;
    }

    @Transactional(readOnly = true)
    public List<Destino> buscarTodos(){
        return destinoRepository.findAll();
    }

    public Destino criar(Destino destino){
        return destinoRepository.save(destino);
    }

}
