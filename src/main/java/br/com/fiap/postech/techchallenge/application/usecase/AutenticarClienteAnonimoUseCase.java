package br.com.fiap.postech.techchallenge.application.usecase;

import br.com.fiap.postech.techchallenge.application.domain.Cliente;
import br.com.fiap.postech.techchallenge.application.domain.DadosTokenJWT;
import br.com.fiap.postech.techchallenge.application.port.inbound.AutenticarClienteAnonimoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.outbound.ClienteRepositoryAdapterPort;
import br.com.fiap.postech.techchallenge.application.port.outbound.JsonWebTokenAdapterPort;

public class AutenticarClienteAnonimoUseCase implements AutenticarClienteAnonimoUseCasePort {

    private final ClienteRepositoryAdapterPort clienteRepositoryAdapterPort;

    private final JsonWebTokenAdapterPort jsonWebTokenAdapterPort;

    public AutenticarClienteAnonimoUseCase(
            ClienteRepositoryAdapterPort clienteRepositoryAdapterPort,
            JsonWebTokenAdapterPort jsonWebTokenAdapterPort
    ) {
        this.clienteRepositoryAdapterPort = clienteRepositoryAdapterPort;
        this.jsonWebTokenAdapterPort = jsonWebTokenAdapterPort;
    }

    @Override
    public DadosTokenJWT executar() {
        Cliente cliente = new Cliente();
        cliente.setNome(Cliente.NOME_ANONIMO);
        cliente.setAnonimo(Boolean.TRUE);
        return this.jsonWebTokenAdapterPort.gerarToken(clienteRepositoryAdapterPort.salvar(cliente));
    }
}
