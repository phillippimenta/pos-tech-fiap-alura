package br.com.fiap.postech.techchallenge.application.usecases;

import br.com.fiap.postech.techchallenge.domain.entities.Cliente;
import br.com.fiap.postech.techchallenge.domain.exception.DominioException;
import br.com.fiap.postech.techchallenge.domain.ports.input.CadastrarClienteUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.output.ClienteRepositoryPort;

public class CadastrarClienteUseCase implements CadastrarClienteUseCasePort {

    private final ClienteRepositoryPort clienteRepositoryPort;

    public CadastrarClienteUseCase(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public Cliente executar(Cliente cliente) {
        Cliente clientePesquisado = this.clienteRepositoryPort.obterPorCPF(cliente.getCpf());
        if (clientePesquisado != null) {
            String mensagem = String.format("Cliente com CPF %s já cadastrado.", cliente.getCpf().getNumero());
            throw new DominioException(mensagem);
        }
        cliente.setAnonimo(Boolean.FALSE);
        return this.clienteRepositoryPort.salvar(cliente);
    }
}
