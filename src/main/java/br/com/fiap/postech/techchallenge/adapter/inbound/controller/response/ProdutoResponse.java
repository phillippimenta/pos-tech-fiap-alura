package br.com.fiap.postech.techchallenge.adapter.inbound.controller.response;

import br.com.fiap.postech.techchallenge.application.domain.TipoProduto;
import br.com.fiap.postech.techchallenge.application.domain.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public record ProdutoResponse(
        Long id,
        @JsonProperty("tipo_produto")
        TipoProduto tipoProduto,
        String nome,
        String descricao,
        BigDecimal preco
) {
    public static ProdutoResponse fromProdutoResponse(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo");
        }
        return new ProdutoResponse(produto.getId(), produto.getTipoProduto(), produto.getNome(), produto.getDescricao(), produto.getPreco());
    }

    public static List<ProdutoResponse> fromProdutoResponseList(List<Produto> produtos) {
        if (produtos == null) return List.of();
        return produtos.stream().map(ProdutoResponse::fromProdutoResponse).collect(Collectors.toList());
    }
}
