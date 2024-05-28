package br.com.fiap.postech.techchallenge.application.port.inbound;

import br.com.fiap.postech.techchallenge.application.domain.DadosTokenJWT;

public interface AutenticarClienteAnonimoUseCasePort {

    DadosTokenJWT executar();
}
