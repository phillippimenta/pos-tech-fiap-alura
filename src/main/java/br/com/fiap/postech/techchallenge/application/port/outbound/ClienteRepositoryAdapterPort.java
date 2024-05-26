package br.com.fiap.postech.techchallenge.application.port.outbound;

import br.com.fiap.postech.techchallenge.application.domain.CPF;
import br.com.fiap.postech.techchallenge.application.domain.Cliente;

public interface ClienteRepositoryAdapterPort {

    Cliente obterPorCPF(CPF cpf);

    Cliente salvar(Cliente cliente);
}
