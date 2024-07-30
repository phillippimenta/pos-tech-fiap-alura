package br.com.fiap.postech.techchallenge.frameworks.data.jpa;

import br.com.fiap.postech.techchallenge.domain.entities.Pedido;
import br.com.fiap.postech.techchallenge.domain.ports.output.PedidoRepositoryPort;
import br.com.fiap.postech.techchallenge.frameworks.data.jpa.entities.PedidoEntity;
import br.com.fiap.postech.techchallenge.frameworks.data.jpa.mappers.PedidoEntityMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class PedidoRepository implements PedidoRepositoryPort {

    private final PedidoJpaRepository pedidoJpaRepository;

    private final PedidoEntityMapper pedidoEntityMapper;

    public PedidoRepository(PedidoJpaRepository pedidoJpaRepository, PedidoEntityMapper pedidoEntityMapper) {
        this.pedidoJpaRepository = pedidoJpaRepository;
        this.pedidoEntityMapper = pedidoEntityMapper;
    }

    @Override
    public List<Pedido> pesquisarPorDataCriacao(LocalDate dataCriacao) {
        return this.pedidoEntityMapper.convertDomainList(this.pedidoJpaRepository.pesquisarPorDataCriacao(dataCriacao));
    }

    @Override
    public Pedido obterPorId(Long id) {
        return this.pedidoEntityMapper.convertDomain(this.pedidoJpaRepository.obterPorId(id));
    }

    @Override
    public Pedido salvar(Pedido pedido) {
        PedidoEntity pedidoEntity = this.pedidoEntityMapper.convertEntity(pedido);
        return this.pedidoEntityMapper.convertDomain(this.pedidoJpaRepository.save(pedidoEntity));
    }
}
