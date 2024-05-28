package br.com.fiap.postech.techchallenge.application.port.outbound;

import br.com.fiap.postech.techchallenge.application.domain.Pedido;

public interface PedidoRepositoryAdapterPort {

    Pedido obterPorId(Long id);

    Pedido salvar(Pedido pedido);
}
