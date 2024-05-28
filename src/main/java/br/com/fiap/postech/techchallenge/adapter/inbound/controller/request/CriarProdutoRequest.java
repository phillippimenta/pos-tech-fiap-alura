package br.com.fiap.postech.techchallenge.adapter.inbound.controller.request;

import br.com.fiap.postech.techchallenge.application.domain.Produto;
import br.com.fiap.postech.techchallenge.application.domain.TipoProduto;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Schema(description = "Requisição para criar um novo produto")
public record CriarProdutoRequest(
        @Schema(description = "Tipo do produto")
        @NotNull(message = "Tipo do produto deve ser informado.")
        @JsonProperty("tipo_produto")
        TipoProduto tipoProduto,
        @Schema(description = "Nome do produto")
        @NotBlank(message = "Nome do produto deve ser informado.")
        String nome,
        @Schema(description = "Descrição do produto")
        @NotBlank(message = "Descrição do produto deve ser informada.")
        String descricao,
        @Schema(description = "Preço do produto")
        @NotNull(message = "Preço do produto deve ser informado.")
        BigDecimal preco
) {
    public static Produto toProduto(CriarProdutoRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request não pode ser nulo");
        }
        Produto produto = new Produto();
        produto.setTipoProduto(request.tipoProduto());
        produto.setNome(request.nome());
        produto.setDescricao(request.descricao());
        produto.setPreco(request.preco());
        return produto;
    }
}
