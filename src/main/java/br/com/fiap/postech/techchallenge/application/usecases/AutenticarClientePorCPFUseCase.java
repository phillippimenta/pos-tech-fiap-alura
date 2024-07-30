package br.com.fiap.postech.techchallenge.application.usecases;

import br.com.fiap.postech.techchallenge.domain.entities.CPF;
import br.com.fiap.postech.techchallenge.domain.entities.Cliente;
import br.com.fiap.postech.techchallenge.domain.entities.DadosTokenJWT;
import br.com.fiap.postech.techchallenge.domain.exception.DominioException;
import br.com.fiap.postech.techchallenge.domain.ports.input.AutenticarClientePorCPFUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.output.ClienteRepositoryPort;
import br.com.fiap.postech.techchallenge.domain.ports.output.JsonWebTokenPort;

public class AutenticarClientePorCPFUseCase implements AutenticarClientePorCPFUseCasePort {

    private final ClienteRepositoryPort clienteRepositoryPort;

    private final JsonWebTokenPort jsonWebTokenPort;

    public AutenticarClientePorCPFUseCase(
            ClienteRepositoryPort clienteRepositoryPort,
            JsonWebTokenPort jsonWebTokenPort
    ) {
        this.clienteRepositoryPort = clienteRepositoryPort;
        this.jsonWebTokenPort = jsonWebTokenPort;
    }

    @Override
    public DadosTokenJWT executar(CPF cpf) {
        Cliente cliente = this.clienteRepositoryPort.obterPorCPF(cpf);
        if (cliente == null) {
            String mensagem = String.format("Cliente com CPF %s não encontrado.", cpf.getNumero());
            throw new DominioException(mensagem);
        }
        return this.jsonWebTokenPort.gerarToken(cliente);
    }
}
