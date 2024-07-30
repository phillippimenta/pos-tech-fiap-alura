package br.com.fiap.postech.techchallenge.application.services;

import br.com.fiap.postech.techchallenge.domain.entities.Pedido;
import br.com.fiap.postech.techchallenge.domain.ports.input.CadastrarPedidoUseCasePort;

public class PedidoService {

    private final CadastrarPedidoUseCasePort cadastrarPedidoUseCasePort;

    public PedidoService(CadastrarPedidoUseCasePort cadastrarPedidoUseCasePort) {
        this.cadastrarPedidoUseCasePort = cadastrarPedidoUseCasePort;
    }

    public Pedido cadastrarPedido(Pedido pedido) {
        return this.cadastrarPedidoUseCasePort.executar(pedido);
    }
}
