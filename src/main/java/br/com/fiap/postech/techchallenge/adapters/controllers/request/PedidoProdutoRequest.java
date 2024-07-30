package br.com.fiap.postech.techchallenge.adapters.controllers.request;

import br.com.fiap.postech.techchallenge.domain.entities.PedidoProduto;
import br.com.fiap.postech.techchallenge.domain.entities.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.stream.Collectors;

public record PedidoProdutoRequest(
        @JsonProperty("nome_produto")
        @NotBlank(message = "Nome do produto deve ser informado.")
        String nomeProduto,
        @Min(value = 1, message = "A quantidade do produto deve ser maior que zero.")
        int quantidade
) {
    public static PedidoProduto toProdutoPedido(PedidoProdutoRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request não pode ser nulo");
        }
        PedidoProduto produtoPedido = new PedidoProduto();
        Produto produto = new Produto();
        produto.setNome(request.nomeProduto());
        produtoPedido.setProduto(produto);
        produtoPedido.setQuantidade(request.quantidade);
        return produtoPedido;
    }

    public static List<PedidoProduto> toProdutoPedidoList(List<PedidoProdutoRequest> requestList) {
        return requestList.stream().map(PedidoProdutoRequest::toProdutoPedido).collect(Collectors.toList());
    }
}
