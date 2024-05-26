package br.com.fiap.postech.techchallenge.adapter.inbound.controller.request;

import br.com.fiap.postech.techchallenge.application.domain.CPF;
import br.com.fiap.postech.techchallenge.application.domain.Cliente;
import br.com.fiap.postech.techchallenge.application.domain.Email;
import jakarta.validation.constraints.NotBlank;

public record CadastrarClienteRequest(
        @NotBlank(message = "CPF deve ser informado.")
        String cpf,
        @NotBlank(message = "Nome deve ser informado.")
        String nome,
        @NotBlank(message = "E-mail deve ser informado.")
        String email
) {
    public static Cliente toCliente(CadastrarClienteRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request não pode ser nulo");
        }
        Cliente cliente = new Cliente();
        cliente.setCpf(new CPF(request.cpf()));
        cliente.setNome(request.nome());
        cliente.setEmail(new Email(request.email()));
        return cliente;
    }
}
