package br.com.fiap.postech.techchallenge.adapter.outbound.repository;

import br.com.fiap.postech.techchallenge.adapter.outbound.repository.entity.PedidoEntity;
import br.com.fiap.postech.techchallenge.adapter.outbound.repository.mapper.ClienteEntityMapper;
import br.com.fiap.postech.techchallenge.adapter.outbound.repository.mapper.PedidoEntityMapper;
import br.com.fiap.postech.techchallenge.application.domain.Pedido;
import br.com.fiap.postech.techchallenge.application.port.outbound.PedidoRepositoryAdapterPort;
import org.springframework.stereotype.Component;

@Component
public class PedidoRepositoryAdapter implements PedidoRepositoryAdapterPort {

    private final PedidoJpaRepository pedidoJpaRepository;

    private final PedidoEntityMapper pedidoEntityMapper;

    private final ClienteEntityMapper clienteEntityMapper;

    public PedidoRepositoryAdapter(PedidoJpaRepository pedidoJpaRepository, PedidoEntityMapper pedidoEntityMapper, ClienteEntityMapper clienteEntityMapper) {
        this.pedidoJpaRepository = pedidoJpaRepository;
        this.pedidoEntityMapper = pedidoEntityMapper;
        this.clienteEntityMapper = clienteEntityMapper;
    }

    @Override
    public Pedido obterPorId(Long id) {
        return this.pedidoEntityMapper.toPedido(this.pedidoJpaRepository.obterPorId(id));
    }

    @Override
    public Pedido salvar(Pedido pedido) {
        PedidoEntity pedidoEntity = this.pedidoEntityMapper.toPedidoEntity(pedido);
        return this.pedidoEntityMapper.toPedido(this.pedidoJpaRepository.save(pedidoEntity));
    }
}
