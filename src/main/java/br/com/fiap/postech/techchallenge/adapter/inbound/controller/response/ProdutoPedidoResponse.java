package br.com.fiap.postech.techchallenge.adapter.inbound.controller.response;

import br.com.fiap.postech.techchallenge.application.domain.ProdutoPedido;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public record ProdutoPedidoResponse(
        String nomeProduto,
        BigDecimal precoProduto,
        Integer quantidade,
        BigDecimal precoTotal
) {
    public static ProdutoPedidoResponse fromProdutoPedidoResponse(ProdutoPedido produtoPedido) {
        if (produtoPedido == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo");
        }
        return new ProdutoPedidoResponse(
                produtoPedido.getProduto().getNome(),
                produtoPedido.getPrecoProduto(),
                produtoPedido.getQuantidade(),
                produtoPedido.getPrecoTotal()
        );
    }

    public static List<ProdutoPedidoResponse> fromProdutoPedidoResponseList(List<ProdutoPedido> produtoPedidoList) {
        if (produtoPedidoList == null) return List.of();
        return produtoPedidoList.stream().map(ProdutoPedidoResponse::fromProdutoPedidoResponse).collect(Collectors.toList());
    }
}
