package br.com.fiap.postech.techchallenge.application.port.inbound;

import br.com.fiap.postech.techchallenge.application.domain.CPF;
import br.com.fiap.postech.techchallenge.application.domain.DadosTokenJWT;

public interface AutenticarClientePorCPFUseCasePort {

    DadosTokenJWT executar(CPF cpf);
}
