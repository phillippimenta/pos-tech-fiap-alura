package br.com.fiap.postech.techchallenge.adapter.inbound.controller.request;

import br.com.fiap.postech.techchallenge.application.domain.Produto;
import br.com.fiap.postech.techchallenge.application.domain.ProdutoPedido;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.stream.Collectors;

public record ProdutoPedidoRequest(
        @JsonProperty("nome_produto")
        @NotBlank(message = "Nome do produto deve ser informado.")
        String nomeProduto,
        @Min(value = 1, message = "A quantidade do produto deve ser maior que zero.")
        int quantidade
) {
    public static ProdutoPedido toProdutoPedido(ProdutoPedidoRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request não pode ser nulo");
        }
        ProdutoPedido produtoPedido = new ProdutoPedido();
        Produto produto = new Produto();
        produto.setNome(request.nomeProduto());
        produtoPedido.setProduto(produto);
        produtoPedido.setQuantidade(request.quantidade);
        return produtoPedido;
    }

    public static List<ProdutoPedido> toProdutoPedidoList(List<ProdutoPedidoRequest> requestList) {
        return requestList.stream().map(ProdutoPedidoRequest::toProdutoPedido).collect(Collectors.toList());
    }
}
