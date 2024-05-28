package br.com.fiap.postech.techchallenge.application.port.inbound;

import br.com.fiap.postech.techchallenge.application.domain.Pedido;

public interface FinalizarPreparacaoPedidoUseCasePort {

    Pedido executar(Long id);
}
