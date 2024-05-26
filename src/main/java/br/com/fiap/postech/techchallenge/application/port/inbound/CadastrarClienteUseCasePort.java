package br.com.fiap.postech.techchallenge.application.port.inbound;

import br.com.fiap.postech.techchallenge.application.domain.Cliente;

public interface CadastrarClienteUseCasePort {

    Cliente executar(Cliente cliente);
}
