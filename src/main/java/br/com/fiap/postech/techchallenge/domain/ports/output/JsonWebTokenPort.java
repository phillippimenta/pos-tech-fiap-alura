package br.com.fiap.postech.techchallenge.domain.ports.output;

import br.com.fiap.postech.techchallenge.domain.entities.Cliente;
import br.com.fiap.postech.techchallenge.domain.entities.DadosTokenJWT;

public interface JsonWebTokenPort {

    DadosTokenJWT gerarToken(Cliente cliente);

    Cliente recuperarClienteToken(String tokenJWT);
}
