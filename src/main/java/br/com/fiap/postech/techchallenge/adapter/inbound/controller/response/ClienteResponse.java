package br.com.fiap.postech.techchallenge.adapter.inbound.controller.response;

import br.com.fiap.postech.techchallenge.application.domain.Cliente;

public record ClienteResponse(
        String cpf,
        String nome,
        String email
) {
    public static ClienteResponse fromClienteResponse(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        return new ClienteResponse(cliente.getCpf().getNumero(), cliente.getNome(), cliente.getEmail().getEndereco());
    }
}
