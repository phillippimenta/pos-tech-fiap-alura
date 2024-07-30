package br.com.fiap.postech.techchallenge.application.usecases;

import br.com.fiap.postech.techchallenge.domain.entities.Cliente;
import br.com.fiap.postech.techchallenge.domain.entities.DadosTokenJWT;
import br.com.fiap.postech.techchallenge.domain.ports.input.AutenticarClienteAnonimoUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.output.ClienteRepositoryPort;
import br.com.fiap.postech.techchallenge.domain.ports.output.JsonWebTokenPort;

public class AutenticarClienteAnonimoUseCase implements AutenticarClienteAnonimoUseCasePort {

    private final ClienteRepositoryPort clienteRepositoryPort;

    private final JsonWebTokenPort jsonWebTokenPort;

    public AutenticarClienteAnonimoUseCase(
            ClienteRepositoryPort clienteRepositoryPort,
            JsonWebTokenPort jsonWebTokenPort
    ) {
        this.clienteRepositoryPort = clienteRepositoryPort;
        this.jsonWebTokenPort = jsonWebTokenPort;
    }

    @Override
    public DadosTokenJWT executar() {
        Cliente cliente = new Cliente();
        cliente.setNome(Cliente.NOME_ANONIMO);
        cliente.setAnonimo(Boolean.TRUE);
        return this.jsonWebTokenPort.gerarToken(clienteRepositoryPort.salvar(cliente));
    }
}
