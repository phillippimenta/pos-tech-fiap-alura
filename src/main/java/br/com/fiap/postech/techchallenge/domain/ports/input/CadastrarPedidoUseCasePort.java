package br.com.fiap.postech.techchallenge.domain.ports.input;

import br.com.fiap.postech.techchallenge.domain.entities.Pedido;

public interface CadastrarPedidoUseCasePort {

    Pedido executar(Pedido pedido);
}
