package br.com.fiap.postech.techchallenge.application.port.outbound;

import br.com.fiap.postech.techchallenge.application.domain.Pedido;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepositoryAdapterPort {

    List<Pedido> pesquisarPorDataCriacao(LocalDate dataCriacao);

    Pedido obterPorId(Long id);

    Pedido salvar(Pedido pedido);
}
