package br.com.fiap.postech.techchallenge.application.port.inbound;

import br.com.fiap.postech.techchallenge.application.domain.Pedido;

public interface PrepararPedidoUseCasePort {

    Pedido executar(Long id);
}
