package br.com.fiap.postech.techchallenge.adapter.outbound.repository.mapper;

import br.com.fiap.postech.techchallenge.adapter.outbound.repository.entity.PedidoEntity;
import br.com.fiap.postech.techchallenge.adapter.outbound.repository.entity.ProdutoPedidoEntity;
import br.com.fiap.postech.techchallenge.application.domain.Pedido;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoEntityMapper {

    private final ProdutoPedidoEntityMapper produtoPedidoEntityMapper;

    private final ClienteEntityMapper clienteEntityMapper;

    public PedidoEntityMapper(
            @Lazy ProdutoPedidoEntityMapper produtoPedidoEntityMapper,
            ClienteEntityMapper clienteEntityMapper
    ) {
        this.produtoPedidoEntityMapper = produtoPedidoEntityMapper;
        this.clienteEntityMapper = clienteEntityMapper;
    }

    public Pedido toPedido(PedidoEntity pedidoEntity) {
        if (pedidoEntity == null) return null;
        Pedido pedido = new Pedido();
        pedido.setId(pedidoEntity.getId());
        pedido.setCliente(this.clienteEntityMapper.toCliente(pedidoEntity.getClienteEntity()));
        pedido.setPrecoTotal(pedidoEntity.getPrecoTotal());
        pedido.setProdutos(this.produtoPedidoEntityMapper.toProdutoPedidoList(pedidoEntity.getProdutoPedidoEntityList()));
        pedido.setStatus(pedidoEntity.getStatus());
        return pedido;
    }

    public List<Pedido> toPedidoList(List<PedidoEntity> pedidoEntityList) {
        if (pedidoEntityList == null) return List.of();
        return pedidoEntityList.stream().map(this::toPedido).collect(Collectors.toList());
    }

    public PedidoEntity toPedidoEntity(Pedido pedido) {
        if (pedido == null) return null;
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setId(pedido.getId());
        pedidoEntity.setClienteEntity(this.clienteEntityMapper.toClienteEntity(pedido.getCliente()));
        pedidoEntity.setPrecoTotal(pedido.getPrecoTotal());
        List<ProdutoPedidoEntity> produtoPedidoEntityList = this.produtoPedidoEntityMapper.toProdutoPedidoEntityList(pedido.getProdutos());
        produtoPedidoEntityList.forEach(produtoPedidoEntity -> produtoPedidoEntity.setPedidoEntity(pedidoEntity));
        pedidoEntity.setProdutoPedidoEntityList(produtoPedidoEntityList);
        pedidoEntity.setStatus(pedido.getStatus());
        return pedidoEntity;
    }

    public List<PedidoEntity> toPedidoEntityList(List<Pedido> pedidoList) {
        if (pedidoList == null) return List.of();
        return pedidoList.stream().map(this::toPedidoEntity).collect(Collectors.toList());
    }
}
