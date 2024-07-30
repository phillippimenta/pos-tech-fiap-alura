package br.com.fiap.postech.techchallenge.domain.ports.input;

import br.com.fiap.postech.techchallenge.domain.entities.Cliente;

public interface CadastrarClienteUseCasePort {

    Cliente executar(Cliente cliente);
}
