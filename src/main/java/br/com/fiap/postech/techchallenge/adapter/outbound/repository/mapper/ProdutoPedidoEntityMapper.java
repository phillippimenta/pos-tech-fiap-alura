package br.com.fiap.postech.techchallenge.adapter.outbound.repository.mapper;

import br.com.fiap.postech.techchallenge.adapter.outbound.repository.entity.ProdutoPedidoEntity;
import br.com.fiap.postech.techchallenge.application.domain.ProdutoPedido;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoPedidoEntityMapper {

    private final ProdutoEntityMapper produtoEntityMapper;

    private final PedidoEntityMapper pedidoEntityMapper;

    public ProdutoPedidoEntityMapper(
            ProdutoEntityMapper produtoEntityMapper,
            @Lazy PedidoEntityMapper pedidoEntityMapper
    ) {
        this.produtoEntityMapper = produtoEntityMapper;
        this.pedidoEntityMapper = pedidoEntityMapper;
    }

    public ProdutoPedido toProdutoPedido(ProdutoPedidoEntity entity) {
        if (entity == null) return null;
        ProdutoPedido produtoPedido = new ProdutoPedido();
        produtoPedido.setId(entity.getId());
        produtoPedido.setProduto(this.produtoEntityMapper.toProduto(entity.getProdutoEntity()));
        produtoPedido.setPrecoProduto(entity.getPrecoProduto());
        produtoPedido.setQuantidade(entity.getQuantidade());
        produtoPedido.setPrecoTotal(entity.getPrecoTotal());
        return produtoPedido;
    }

    public List<ProdutoPedido> toProdutoPedidoList(List<ProdutoPedidoEntity> entityList) {
        if (entityList == null) return List.of();
        return entityList.stream().map(this::toProdutoPedido).collect(Collectors.toList());
    }

    public ProdutoPedidoEntity toProdutoPedidoEntity(ProdutoPedido produtoPedido) {
        if (produtoPedido == null) return null;
        ProdutoPedidoEntity produtoPedidoEntity = new ProdutoPedidoEntity();
        produtoPedidoEntity.setId(produtoPedido.getId());
        produtoPedidoEntity.setPedidoEntity(this.pedidoEntityMapper.toPedidoEntity(produtoPedido.getPedido()));
        produtoPedidoEntity.setProdutoEntity(this.produtoEntityMapper.toProdutoEntity(produtoPedido.getProduto()));
        produtoPedidoEntity.setPrecoProduto(produtoPedido.getPrecoProduto());
        produtoPedidoEntity.setQuantidade(produtoPedido.getQuantidade());
        produtoPedidoEntity.setPrecoTotal(produtoPedido.getPrecoTotal());
        return produtoPedidoEntity;
    }

    public List<ProdutoPedidoEntity> toProdutoPedidoEntityList(List<ProdutoPedido> produtoPedidoList) {
        if (produtoPedidoList == null) return List.of();
        return produtoPedidoList.stream().map(this::toProdutoPedidoEntity).collect(Collectors.toList());
    }
}
