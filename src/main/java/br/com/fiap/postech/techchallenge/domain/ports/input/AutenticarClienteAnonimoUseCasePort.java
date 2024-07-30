package br.com.fiap.postech.techchallenge.domain.ports.input;

import br.com.fiap.postech.techchallenge.domain.entities.DadosTokenJWT;

public interface AutenticarClienteAnonimoUseCasePort {

    DadosTokenJWT executar();
}
