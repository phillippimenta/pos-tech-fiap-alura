package br.com.fiap.postech.techchallenge.domain.ports.input;

import br.com.fiap.postech.techchallenge.domain.entities.CPF;
import br.com.fiap.postech.techchallenge.domain.entities.DadosTokenJWT;

public interface AutenticarClientePorCPFUseCasePort {

    DadosTokenJWT executar(CPF cpf);
}
