package br.com.fiap.postech.techchallenge.domain.ports.output;

import br.com.fiap.postech.techchallenge.domain.entities.Pedido;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepositoryPort {

    List<Pedido> pesquisarPorDataCriacao(LocalDate dataCriacao);

    Pedido obterPorId(Long id);

    Pedido salvar(Pedido pedido);
}
