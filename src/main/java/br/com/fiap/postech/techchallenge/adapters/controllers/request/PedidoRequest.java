package br.com.fiap.postech.techchallenge.adapters.controllers.request;

import br.com.fiap.postech.techchallenge.domain.entities.Pedido;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import java.util.List;

public record PedidoRequest(
        @Schema(description = "produtos")
        @Size(min = 1, message = "Selecione pelo menos um produto para fazer o pedido.")
        @Valid
        List<PedidoProdutoRequest> produtos
) {
    public static Pedido toPedido(PedidoRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request não pode ser nulo");
        }
        Pedido pedido = new Pedido();
        pedido.setProdutos(PedidoProdutoRequest.toProdutoPedidoList(request.produtos()));
        return pedido;
    }
}
