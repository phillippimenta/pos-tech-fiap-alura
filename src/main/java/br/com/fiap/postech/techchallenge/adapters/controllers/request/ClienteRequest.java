package br.com.fiap.postech.techchallenge.adapters.controllers.request;

import br.com.fiap.postech.techchallenge.domain.builders.ClienteBuilder;
import br.com.fiap.postech.techchallenge.domain.entities.CPF;
import br.com.fiap.postech.techchallenge.domain.entities.Cliente;
import br.com.fiap.postech.techchallenge.domain.entities.Email;
import jakarta.validation.constraints.NotBlank;

public record ClienteRequest(
        @NotBlank(message = "CPF deve ser informado.")
        String cpf,
        @NotBlank(message = "Nome deve ser informado.")
        String nome,
        @NotBlank(message = "E-mail deve ser informado.")
        String email
) {
    public static Cliente to(ClienteRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request não pode ser nulo");
        }
        return new ClienteBuilder()
                .cpf(new CPF(request.cpf()))
                .nome(request.nome())
                .email(new Email(request.email()))
                .build();
    }
}
