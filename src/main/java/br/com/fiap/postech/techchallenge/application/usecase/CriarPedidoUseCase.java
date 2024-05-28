package br.com.fiap.postech.techchallenge.application.usecase;

import br.com.fiap.postech.techchallenge.application.domain.Pedido;
import br.com.fiap.postech.techchallenge.application.domain.ProdutoPedido;
import br.com.fiap.postech.techchallenge.application.domain.StatusPedido;
import br.com.fiap.postech.techchallenge.application.port.inbound.CriarPedidoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.outbound.PedidoRepositoryAdapterPort;
import br.com.fiap.postech.techchallenge.application.port.outbound.ProdutoRepositoryAdapterPort;
import br.com.fiap.postech.techchallenge.application.port.outbound.SecurityContextAdapterPort;

import java.math.BigDecimal;

public class CriarPedidoUseCase implements CriarPedidoUseCasePort {

    private final PedidoRepositoryAdapterPort pedidoRepositoryAdapterPort;

    private final ProdutoRepositoryAdapterPort produtoRepositoryAdapterPort;

    private final SecurityContextAdapterPort securityContextAdapterPort;

    public CriarPedidoUseCase(
            PedidoRepositoryAdapterPort pedidoRepositoryAdapterPort,
            ProdutoRepositoryAdapterPort produtoRepositoryAdapterPort,
            SecurityContextAdapterPort securityContextAdapterPort
    ) {
        this.pedidoRepositoryAdapterPort = pedidoRepositoryAdapterPort;
        this.produtoRepositoryAdapterPort = produtoRepositoryAdapterPort;
        this.securityContextAdapterPort = securityContextAdapterPort;
    }

    @Override
    public Pedido executar(Pedido pedido) {
        for (ProdutoPedido produtoPedido : pedido.getProdutos()) {
            produtoPedido.setProduto(produtoRepositoryAdapterPort.obterPorNome(produtoPedido.getProduto().getNome()));
            BigDecimal precoTotalProdutoPedido = produtoPedido.getProduto().getPreco().multiply(BigDecimal.valueOf(produtoPedido.getQuantidade()));
            produtoPedido.setPrecoProduto(produtoPedido.getProduto().getPreco());
            produtoPedido.setPrecoTotal(precoTotalProdutoPedido);
            pedido.setPrecoTotal(pedido.getPrecoTotal().add(produtoPedido.getPrecoTotal()));
        }
        pedido.setCliente(this.securityContextAdapterPort.obterClienteAutenticado());
        pedido.setStatus(StatusPedido.RECEBIDO);
        return pedidoRepositoryAdapterPort.salvar(pedido);
    }
}
