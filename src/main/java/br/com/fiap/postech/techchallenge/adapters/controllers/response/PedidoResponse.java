package br.com.fiap.postech.techchallenge.adapters.controllers.response;

import br.com.fiap.postech.techchallenge.domain.entities.Pedido;
import br.com.fiap.postech.techchallenge.domain.enums.StatusPedido;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public record PedidoResponse(
        Long id,
        ClienteResponse cliente,
        BigDecimal precoTotal,
        List<PedidoProdutoResponse> produtos,
        StatusPedido status
) {
    public static PedidoResponse from(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo");
        }
        return new PedidoResponse(pedido.getId(), ClienteResponse.from(pedido.getCliente()), pedido.getPrecoTotal(),
                PedidoProdutoResponse.fromList(pedido.getProdutos()), pedido.getStatus());
    }

    public static List<PedidoResponse> fromList(List<Pedido> pedidoList) {
        if (pedidoList == null) {
            throw new IllegalArgumentException("PedidoList não pode ser nulo");
        }
        return pedidoList.stream().map(PedidoResponse::from).collect(Collectors.toList());
    }
}
