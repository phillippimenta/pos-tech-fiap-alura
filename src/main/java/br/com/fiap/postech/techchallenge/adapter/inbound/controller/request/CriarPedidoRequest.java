package br.com.fiap.postech.techchallenge.adapter.inbound.controller.request;

import br.com.fiap.postech.techchallenge.application.domain.Pedido;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CriarPedidoRequest(
        @Schema(description = "produtos")
        @Size(min = 1, message = "Selecione pelo menos um produto para fazer o pedido.")
        @Valid
        List<ProdutoPedidoRequest> produtos
) {
    public static Pedido toPedido(CriarPedidoRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request não pode ser nulo");
        }
        Pedido pedido = new Pedido();
        pedido.setProdutos(ProdutoPedidoRequest.toProdutoPedidoList(request.produtos()));
        return pedido;
    }
}
