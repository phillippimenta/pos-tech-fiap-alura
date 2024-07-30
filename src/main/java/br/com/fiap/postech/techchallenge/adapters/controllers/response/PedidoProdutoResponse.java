package br.com.fiap.postech.techchallenge.adapters.controllers.response;

import br.com.fiap.postech.techchallenge.domain.entities.PedidoProduto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public record PedidoProdutoResponse(
        String nomeProduto,
        BigDecimal precoProduto,
        Integer quantidade,
        BigDecimal precoTotal
) {
    public static PedidoProdutoResponse from(PedidoProduto produtoPedido) {
        if (produtoPedido == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo");
        }
        return new PedidoProdutoResponse(
                produtoPedido.getProduto().getNome(),
                produtoPedido.getPrecoProduto(),
                produtoPedido.getQuantidade(),
                produtoPedido.getPrecoTotal()
        );
    }

    public static List<PedidoProdutoResponse> fromList(List<PedidoProduto> produtoPedidoList) {
        if (produtoPedidoList == null) return List.of();
        return produtoPedidoList.stream().map(PedidoProdutoResponse::from).collect(Collectors.toList());
    }
}
