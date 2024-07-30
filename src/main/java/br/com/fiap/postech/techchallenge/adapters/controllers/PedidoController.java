package br.com.fiap.postech.techchallenge.adapters.controllers;

import br.com.fiap.postech.techchallenge.adapters.controllers.request.PedidoRequest;
import br.com.fiap.postech.techchallenge.adapters.controllers.response.PedidoResponse;
import br.com.fiap.postech.techchallenge.application.services.PedidoService;
import br.com.fiap.postech.techchallenge.domain.entities.Pedido;
import br.com.fiap.postech.techchallenge.domain.enums.StatusPedido;

import java.time.LocalDate;
import java.util.List;

public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    public PedidoResponse cadastrarPedido(PedidoRequest request) {
        Pedido pedido = PedidoRequest.toPedido(request);
        return PedidoResponse.from(this.pedidoService.cadastrarPedido(pedido));
    }

    public List<PedidoResponse> listarPedidosPorDataCriacao(LocalDate dataCriacao) {
        return PedidoResponse.fromList(this.pedidoService.listarPedidosPorDataCriacao(dataCriacao));
    }

    public PedidoResponse alterarStatusPedido(Long pedidoId, StatusPedido novoStatus) {
        return PedidoResponse.from(this.pedidoService.alterarStatusPedido(pedidoId, novoStatus));
    }
}
