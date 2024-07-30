package br.com.fiap.postech.techchallenge.domain.ports.input;

import br.com.fiap.postech.techchallenge.domain.entities.Cliente;

import java.util.List;

public interface ListarClientesUseCasePort {

    List<Cliente> executar(String cpf);
}
