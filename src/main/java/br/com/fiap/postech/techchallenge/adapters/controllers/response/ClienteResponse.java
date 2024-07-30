package br.com.fiap.postech.techchallenge.adapters.controllers.response;

import br.com.fiap.postech.techchallenge.domain.entities.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public record ClienteResponse(
        Long id,
        String cpf,
        String nome,
        String email
) {
    public static ClienteResponse from(Cliente cliente) {
        String numeroCPF = cliente.getCpf() == null ? null : cliente.getCpf().getNumero();
        String enderecoEmail = cliente.getEmail() == null ? null : cliente.getEmail().getEndereco();
        return new ClienteResponse(cliente.getId(), numeroCPF, cliente.getNome(), enderecoEmail);
    }

    public static List<ClienteResponse> fromList(List<Cliente> clienteList) {
        return clienteList.stream().map(ClienteResponse::from).collect(Collectors.toList());
    }
}
