package br.com.fiap.postech.techchallenge.adapters.controllers.request;

import br.com.fiap.postech.techchallenge.domain.entities.Produto;
import br.com.fiap.postech.techchallenge.domain.enums.CategoriaProduto;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Schema(description = "Requisição para criar um novo produto")
public record ProdutoRequest(
        @Schema(description = "Tipo do produto")
        @NotNull(message = "Tipo do produto deve ser informado.")
        @JsonProperty("categoria")
        CategoriaProduto categoria,
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
    public static Produto to(ProdutoRequest request) {
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
