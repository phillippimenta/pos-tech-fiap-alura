package br.com.fiap.postech.techchallenge.adapters.controllers;

import br.com.fiap.postech.techchallenge.adapters.controllers.request.PedidoRequest;
import br.com.fiap.postech.techchallenge.adapters.controllers.response.PedidoResponse;
import br.com.fiap.postech.techchallenge.application.services.PedidoService;
import br.com.fiap.postech.techchallenge.domain.entities.Pedido;

public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    public PedidoResponse cadastrarPedido(PedidoRequest request) {
        Pedido pedido = PedidoRequest.toPedido(request);
        return PedidoResponse.from(this.pedidoService.cadastrarPedido(pedido));
    }
}
