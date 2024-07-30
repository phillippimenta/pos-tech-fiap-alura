package br.com.fiap.postech.techchallenge.domain.ports.output;

import br.com.fiap.postech.techchallenge.domain.entities.CPF;
import br.com.fiap.postech.techchallenge.domain.entities.Cliente;

import java.util.List;

public interface ClienteRepositoryPort {

    List<Cliente> listar();

    Cliente obterPorId(Long id);

    Cliente obterPorCPF(CPF cpf);

    Cliente salvar(Cliente cliente);
}
