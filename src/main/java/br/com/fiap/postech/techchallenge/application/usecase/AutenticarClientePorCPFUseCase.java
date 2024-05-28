package br.com.fiap.postech.techchallenge.application.usecase;

import br.com.fiap.postech.techchallenge.application.domain.CPF;
import br.com.fiap.postech.techchallenge.application.domain.Cliente;
import br.com.fiap.postech.techchallenge.application.domain.DadosTokenJWT;
import br.com.fiap.postech.techchallenge.application.exception.DominioException;
import br.com.fiap.postech.techchallenge.application.port.inbound.AutenticarClientePorCPFUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.outbound.ClienteRepositoryAdapterPort;
import br.com.fiap.postech.techchallenge.application.port.outbound.JsonWebTokenAdapterPort;

public class AutenticarClientePorCPFUseCase implements AutenticarClientePorCPFUseCasePort {

    private final ClienteRepositoryAdapterPort clienteRepositoryAdapterPort;

    private final JsonWebTokenAdapterPort jsonWebTokenAdapterPort;

    public AutenticarClientePorCPFUseCase(
            ClienteRepositoryAdapterPort clienteRepositoryAdapterPort,
            JsonWebTokenAdapterPort jsonWebTokenAdapterPort
    ) {
        this.clienteRepositoryAdapterPort = clienteRepositoryAdapterPort;
        this.jsonWebTokenAdapterPort = jsonWebTokenAdapterPort;
    }

    @Override
    public DadosTokenJWT executar(CPF cpf) {
        Cliente cliente = this.clienteRepositoryAdapterPort.obterPorCPF(cpf);
        if (cliente == null) {
            String mensagem = String.format("Cliente com CPF %s não encontrado.", cpf.getNumero());
            throw new DominioException(mensagem);
        }
        return this.jsonWebTokenAdapterPort.gerarToken(cliente);
    }
}
