package com.agencia.viagem.dtos;


import com.agencia.viagem.models.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
