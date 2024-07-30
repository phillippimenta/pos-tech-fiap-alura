package br.com.fiap.postech.techchallenge.adapters.controllers.response;

import br.com.fiap.postech.techchallenge.domain.entities.Produto;
import br.com.fiap.postech.techchallenge.domain.enums.CategoriaProduto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public record ProdutoResponse(
        Long id,
        @JsonProperty("tipo_produto")
        CategoriaProduto categoriaProduto,
        String nome,
        String descricao,
        BigDecimal preco
) {
    public static ProdutoResponse from(Produto produto) {
        return new ProdutoResponse(produto.getId(), produto.getCategoria(), produto.getNome(), produto.getDescricao(), produto.getPreco());
    }

    public static List<ProdutoResponse> fromList(List<Produto> produtos) {
        return produtos.stream().map(ProdutoResponse::from).collect(Collectors.toList());
    }
}
