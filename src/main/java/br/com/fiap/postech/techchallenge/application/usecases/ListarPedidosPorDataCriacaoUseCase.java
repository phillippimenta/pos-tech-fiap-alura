package br.com.fiap.postech.techchallenge.application.usecases;

import br.com.fiap.postech.techchallenge.domain.entities.Pedido;
import br.com.fiap.postech.techchallenge.domain.ports.input.ListarPedidosPorDataCriacaoUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.output.PedidoRepositoryPort;

import java.time.LocalDate;
import java.util.List;

public class ListarPedidosPorDataCriacaoUseCase implements ListarPedidosPorDataCriacaoUseCasePort {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    public ListarPedidosPorDataCriacaoUseCase(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }

    @Override
    public List<Pedido> executar(LocalDate dataCriacao) {
        return pedidoRepositoryPort.pesquisarPorDataCriacao(dataCriacao);
    }
}
