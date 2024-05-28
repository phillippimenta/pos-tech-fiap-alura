package br.com.fiap.postech.techchallenge.adapter.inbound.controller.request;

import jakarta.validation.constraints.NotBlank;

public record AutenticarClienteRequest(
        @NotBlank(message = "CPF deve ser informado.")
        String cpf
) {
}
