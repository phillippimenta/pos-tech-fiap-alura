package br.com.fiap.postech.techchallenge.adapter.inbound.controller.request;

import br.com.fiap.postech.techchallenge.application.domain.CategoriaEnum;
import br.com.fiap.postech.techchallenge.application.domain.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CriarProdutoRequest(
        @NotNull(message = "Categoria do produto deve ser informada.")
        CategoriaEnum categoria,
        @NotBlank(message = "Nome do produto deve ser informado.")
        String nome,
        @NotBlank(message = "Descrição do produto deve ser informada.")
        String descricao,
        @NotNull(message = "Preço do produto deve ser informado.")
        BigDecimal preco
) {
    public static Produto toProduto(CriarProdutoRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request não pode ser nulo");
        }
        Produto produto = new Produto();
        produto.setCategoria(request.categoria());
        produto.setNome(request.nome());
        produto.setDescricao(request.descricao());
        produto.setPreco(request.preco());
        return produto;
    }
}
