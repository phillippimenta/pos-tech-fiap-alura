package br.com.fiap.postech.techchallenge.application.usecase;

import br.com.fiap.postech.techchallenge.application.domain.Cliente;
import br.com.fiap.postech.techchallenge.application.exception.DominioException;
import br.com.fiap.postech.techchallenge.application.port.inbound.CadastrarClienteUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.outbound.ClienteRepositoryAdapterPort;

public class CadastrarClienteUseCase implements CadastrarClienteUseCasePort {

    private final ClienteRepositoryAdapterPort clienteRepositoryAdapterPort;

    public CadastrarClienteUseCase(ClienteRepositoryAdapterPort clienteRepositoryAdapterPort) {
        this.clienteRepositoryAdapterPort = clienteRepositoryAdapterPort;
    }

    @Override
    public Cliente executar(Cliente cliente) {
        Cliente clientePesquisado = this.clienteRepositoryAdapterPort.obterPorCPF(cliente.getCpf());
        if (clientePesquisado != null) {
            String mensagem = String.format("Cliente com CPF %s já cadastrado.", cliente.getCpf().getNumero());
            throw new DominioException(mensagem);
        }
        cliente.setAnonimo(Boolean.FALSE);
        return this.clienteRepositoryAdapterPort.salvar(cliente);
    }
}
