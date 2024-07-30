package br.com.fiap.postech.techchallenge.adapters.controllers.request;

import jakarta.validation.constraints.NotBlank;

public record AutenticarClienteRequest(
        @NotBlank(message = "CPF deve ser informado.")
        String cpf
) {
}
