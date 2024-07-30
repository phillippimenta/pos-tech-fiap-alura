package br.com.fiap.postech.techchallenge.application.usecases;

import br.com.fiap.postech.techchallenge.domain.entities.CPF;
import br.com.fiap.postech.techchallenge.domain.entities.Cliente;
import br.com.fiap.postech.techchallenge.domain.ports.input.ListarClientesUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.output.ClienteRepositoryPort;

import java.util.Collections;
import java.util.List;

public class ListarClientesUseCase implements ListarClientesUseCasePort {

    private final ClienteRepositoryPort clienteRepositoryPort;

    public ListarClientesUseCase(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public List<Cliente> executar(String cpf) {
        if (cpf == null || cpf.isEmpty()) return this.clienteRepositoryPort.listar();
        Cliente cliente = this.clienteRepositoryPort.obterPorCPF(new CPF(cpf));
        if (cliente == null) return Collections.emptyList();
        return List.of(cliente);
    }
}
