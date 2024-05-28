package br.com.fiap.postech.techchallenge.application.port.outbound;

import br.com.fiap.postech.techchallenge.application.domain.Cliente;

public interface SecurityContextAdapterPort {

    Cliente obterClienteAutenticado();
}
