package br.com.fiap.postech.techchallenge.application.port.inbound;

import br.com.fiap.postech.techchallenge.application.domain.Pedido;

public interface PagarPedidoUseCasePort {

    Pedido executar(Long id);
}
