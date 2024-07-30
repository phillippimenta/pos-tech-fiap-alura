package br.com.fiap.postech.techchallenge.frameworks.data.jpa.mappers;

import br.com.fiap.postech.techchallenge.domain.entities.PedidoProduto;
import br.com.fiap.postech.techchallenge.frameworks.data.jpa.entities.PedidoProdutoEntity;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoProdutoEntityMapper {

    private final ProdutoEntityMapper produtoEntityMapper;

    private final PedidoEntityMapper pedidoEntityMapper;

    public PedidoProdutoEntityMapper(
            ProdutoEntityMapper produtoEntityMapper,
            @Lazy PedidoEntityMapper pedidoEntityMapper
    ) {
        this.produtoEntityMapper = produtoEntityMapper;
        this.pedidoEntityMapper = pedidoEntityMapper;
    }

    public PedidoProduto convertDomain(PedidoProdutoEntity entity) {
        if (entity == null) return null;
        PedidoProduto produtoPedido = new PedidoProduto();
        produtoPedido.setId(entity.getId());
        produtoPedido.setProduto(this.produtoEntityMapper.convertDomain(entity.getProdutoEntity()));
        produtoPedido.setPrecoProduto(entity.getPrecoProduto());
        produtoPedido.setQuantidade(entity.getQuantidade());
        produtoPedido.setPrecoTotal(entity.getPrecoTotal());
        return produtoPedido;
    }

    public List<PedidoProduto> convertDomainList(List<PedidoProdutoEntity> entityList) {
        if (entityList == null) return List.of();
        return entityList.stream().map(this::convertDomain).collect(Collectors.toList());
    }

    public PedidoProdutoEntity convertEntity(PedidoProduto produtoPedido) {
        if (produtoPedido == null) return null;
        PedidoProdutoEntity produtoPedidoEntity = new PedidoProdutoEntity();
        produtoPedidoEntity.setId(produtoPedido.getId());
        produtoPedidoEntity.setPedidoEntity(this.pedidoEntityMapper.convertEntity(produtoPedido.getPedido()));
        produtoPedidoEntity.setProdutoEntity(this.produtoEntityMapper.convertEntity(produtoPedido.getProduto()));
        produtoPedidoEntity.setPrecoProduto(produtoPedido.getPrecoProduto());
        produtoPedidoEntity.setQuantidade(produtoPedido.getQuantidade());
        produtoPedidoEntity.setPrecoTotal(produtoPedido.getPrecoTotal());
        return produtoPedidoEntity;
    }

    public List<PedidoProdutoEntity> convertEntityList(List<PedidoProduto> produtoPedidoList) {
        if (produtoPedidoList == null) return List.of();
        return produtoPedidoList.stream().map(this::convertEntity).collect(Collectors.toList());
    }
}
