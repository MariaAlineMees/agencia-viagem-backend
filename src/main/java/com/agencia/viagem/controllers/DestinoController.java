package com.agencia.viagem.controllers;

import com.agencia.viagem.models.Destino;
import com.agencia.viagem.models.Reserva;
import com.agencia.viagem.repositories.DestinoRepository;
import com.agencia.viagem.services.DestinoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinos")
public class DestinoController {

    public final DestinoService destinoService;

    public DestinoController(DestinoService destinoService) {
        this.destinoService = destinoService;
    }

    @GetMapping
    public ResponseEntity<List<Destino>> buscarTodos() {
        return ResponseEntity.ok(destinoService.buscarTodos());
    }
    @PostMapping
    public ResponseEntity<Destino> criar(@RequestBody Destino destino){
        return ResponseEntity.ok(destinoService.criar(destino));

    }
}
