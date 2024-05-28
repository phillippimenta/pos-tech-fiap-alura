package br.com.fiap.postech.techchallenge.adapter.inbound.controller.response;

import br.com.fiap.postech.techchallenge.application.domain.Pedido;
import br.com.fiap.postech.techchallenge.application.domain.StatusPedido;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public record PedidoResponse(
        Long id,
        ClienteResponse cliente,
        BigDecimal precoTotal,
        List<ProdutoPedidoResponse> produtos,
        StatusPedido status
) {
    public static PedidoResponse fromPedidoResponse(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo");
        }
        return new PedidoResponse(pedido.getId(), ClienteResponse.fromClienteResponse(pedido.getCliente()), pedido.getPrecoTotal(),
                ProdutoPedidoResponse.fromProdutoPedidoResponseList(pedido.getProdutos()), pedido.getStatus());
    }

    public static List<PedidoResponse> fromPedidoResponseList(List<Pedido> pedidoList) {
        if (pedidoList == null) {
            throw new IllegalArgumentException("PedidoList não pode ser nulo");
        }
        return pedidoList.stream().map(PedidoResponse::fromPedidoResponse).collect(Collectors.toList());
    }
}
