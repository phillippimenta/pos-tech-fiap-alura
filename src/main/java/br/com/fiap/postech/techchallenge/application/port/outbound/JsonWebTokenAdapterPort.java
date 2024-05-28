package br.com.fiap.postech.techchallenge.application.port.outbound;

import br.com.fiap.postech.techchallenge.application.domain.Cliente;
import br.com.fiap.postech.techchallenge.application.domain.DadosTokenJWT;

public interface JsonWebTokenAdapterPort {

    DadosTokenJWT gerarToken(Cliente cliente);

    Cliente recuperarClienteToken(String tokenJWT);
}
