package br.com.fiap.postech.techchallenge.domain.ports.output;

import br.com.fiap.postech.techchallenge.domain.entities.Cliente;

public interface SecurityContextPort {

    Cliente obterClienteAutenticado();
}
