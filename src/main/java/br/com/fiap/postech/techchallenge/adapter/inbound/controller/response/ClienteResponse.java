package br.com.fiap.postech.techchallenge.adapter.inbound.controller.response;

import br.com.fiap.postech.techchallenge.application.domain.Cliente;

public record ClienteResponse(
        Long id,
        String cpf,
        String nome,
        String email
) {
    public static ClienteResponse fromClienteResponse(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        String numeroCPF = cliente.getCpf() == null ? null : cliente.getCpf().getNumero();
        String enderecoEmail = cliente.getEmail() == null ? null : cliente.getEmail().getEndereco();
        return new ClienteResponse(cliente.getId(), numeroCPF, cliente.getNome(), enderecoEmail);
    }
}
