package br.com.fiap.postech.techchallenge.domain.ports.input;

import br.com.fiap.postech.techchallenge.domain.entities.Pedido;
import br.com.fiap.postech.techchallenge.domain.enums.StatusPedido;

public interface AlterarStatusPedidoUseCasePort {

    Pedido executar(Long pedidoId, StatusPedido novoStatus);
}
