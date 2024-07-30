package br.com.fiap.postech.techchallenge.application.usecases;

import br.com.fiap.postech.techchallenge.domain.entities.Pedido;
import br.com.fiap.postech.techchallenge.domain.entities.PedidoProduto;
import br.com.fiap.postech.techchallenge.domain.enums.StatusPedido;
import br.com.fiap.postech.techchallenge.domain.ports.input.CadastrarPedidoUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.output.PedidoRepositoryPort;
import br.com.fiap.postech.techchallenge.domain.ports.output.ProdutoRepositoryPort;
import br.com.fiap.postech.techchallenge.domain.ports.output.SecurityContextPort;

import java.math.BigDecimal;

public class CadastrarPedidoUseCase implements CadastrarPedidoUseCasePort {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    private final ProdutoRepositoryPort produtoRepositoryPort;

    private final SecurityContextPort securityContextPort;

    public CadastrarPedidoUseCase(PedidoRepositoryPort pedidoRepositoryPort,
                                  ProdutoRepositoryPort produtoRepositoryPort,
                                  SecurityContextPort securityContextPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
        this.produtoRepositoryPort = produtoRepositoryPort;
        this.securityContextPort = securityContextPort;
    }

    @Override
    public Pedido executar(Pedido pedido) {
        for (PedidoProduto produtoPedido : pedido.getProdutos()) {
            produtoPedido.setProduto(produtoRepositoryPort.obterPorNome(produtoPedido.getProduto().getNome()));
            BigDecimal precoTotalProdutoPedido = produtoPedido.getProduto().getPreco().multiply(BigDecimal.valueOf(produtoPedido.getQuantidade()));
            produtoPedido.setPrecoProduto(produtoPedido.getProduto().getPreco());
            produtoPedido.setPrecoTotal(precoTotalProdutoPedido);
            pedido.setPrecoTotal(pedido.getPrecoTotal().add(produtoPedido.getPrecoTotal()));
        }
        pedido.setCliente(this.securityContextPort.obterClienteAutenticado());
        pedido.alterarStatus(StatusPedido.RECEBIDO);
        return pedidoRepositoryPort.salvar(pedido);
    }
}
