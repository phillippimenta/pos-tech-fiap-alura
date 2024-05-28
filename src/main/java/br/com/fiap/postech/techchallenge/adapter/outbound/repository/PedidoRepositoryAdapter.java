package br.com.fiap.postech.techchallenge.adapter.outbound.repository;

import br.com.fiap.postech.techchallenge.adapter.outbound.repository.entity.PedidoEntity;
import br.com.fiap.postech.techchallenge.adapter.outbound.repository.mapper.PedidoEntityMapper;
import br.com.fiap.postech.techchallenge.application.domain.Pedido;
import br.com.fiap.postech.techchallenge.application.port.outbound.PedidoRepositoryAdapterPort;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class PedidoRepositoryAdapter implements PedidoRepositoryAdapterPort {

    private final PedidoJpaRepository pedidoJpaRepository;

    private final PedidoEntityMapper pedidoEntityMapper;

    public PedidoRepositoryAdapter(PedidoJpaRepository pedidoJpaRepository, PedidoEntityMapper pedidoEntityMapper) {
        this.pedidoJpaRepository = pedidoJpaRepository;
        this.pedidoEntityMapper = pedidoEntityMapper;
    }

    @Override
    public List<Pedido> pesquisarPorDataCriacao(LocalDate dataCriacao) {
        return this.pedidoEntityMapper.toPedidoList(this.pedidoJpaRepository.pesquisarPorDataCriacao(dataCriacao));
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
