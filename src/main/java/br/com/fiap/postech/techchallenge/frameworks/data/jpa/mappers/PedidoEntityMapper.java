package br.com.fiap.postech.techchallenge.frameworks.data.jpa.mappers;

import br.com.fiap.postech.techchallenge.domain.entities.Pedido;
import br.com.fiap.postech.techchallenge.frameworks.data.jpa.entities.PedidoEntity;
import br.com.fiap.postech.techchallenge.frameworks.data.jpa.entities.PedidoProdutoEntity;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoEntityMapper {

    private final PedidoProdutoEntityMapper pedidoProdutoEntityMapper;

    private final ClienteEntityMapper clienteEntityMapper;

    public PedidoEntityMapper(
            @Lazy PedidoProdutoEntityMapper pedidoProdutoEntityMapper,
            ClienteEntityMapper clienteEntityMapper
    ) {
        this.pedidoProdutoEntityMapper = pedidoProdutoEntityMapper;
        this.clienteEntityMapper = clienteEntityMapper;
    }

    public Pedido convertDomain(PedidoEntity pedidoEntity) {
        if (pedidoEntity == null) return null;
        Pedido pedido = new Pedido();
        pedido.setId(pedidoEntity.getId());
        pedido.setCliente(this.clienteEntityMapper.convertDomain(pedidoEntity.getClienteEntity()));
        pedido.setPrecoTotal(pedidoEntity.getPrecoTotal());
        pedido.setProdutos(this.pedidoProdutoEntityMapper.convertDomainList(pedidoEntity.getProdutoPedidoEntityList()));
        pedido.setStatus(pedidoEntity.getStatus());
        return pedido;
    }

    public List<Pedido> convertDomainList(List<PedidoEntity> pedidoEntityList) {
        if (pedidoEntityList == null) return List.of();
        return pedidoEntityList.stream().map(this::convertDomain).collect(Collectors.toList());
    }

    public PedidoEntity convertEntity(Pedido pedido) {
        if (pedido == null) return null;
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setId(pedido.getId());
        pedidoEntity.setClienteEntity(this.clienteEntityMapper.convertEntity(pedido.getCliente()));
        pedidoEntity.setPrecoTotal(pedido.getPrecoTotal());
        List<PedidoProdutoEntity> produtoPedidoEntityList = this.pedidoProdutoEntityMapper.convertEntityList(pedido.getProdutos());
        produtoPedidoEntityList.forEach(produtoPedidoEntity -> produtoPedidoEntity.setPedidoEntity(pedidoEntity));
        pedidoEntity.setProdutoPedidoEntityList(produtoPedidoEntityList);
        pedidoEntity.setStatus(pedido.getStatus());
        return pedidoEntity;
    }

    public List<PedidoEntity> convertEntityList(List<Pedido> pedidoList) {
        if (pedidoList == null) return List.of();
        return pedidoList.stream().map(this::convertEntity).collect(Collectors.toList());
    }
}
