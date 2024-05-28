package br.com.fiap.postech.techchallenge.application.usecase;

import br.com.fiap.postech.techchallenge.application.domain.Pedido;
import br.com.fiap.postech.techchallenge.application.port.inbound.ListarPedidosPorDataCriacaoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.outbound.PedidoRepositoryAdapterPort;

import java.time.LocalDate;
import java.util.List;

public class ListarPedidosPorDataCriacaoUseCase implements ListarPedidosPorDataCriacaoUseCasePort {

    private final PedidoRepositoryAdapterPort pedidoRepositoryAdapterPort;

    public ListarPedidosPorDataCriacaoUseCase(PedidoRepositoryAdapterPort pedidoRepositoryAdapterPort) {
        this.pedidoRepositoryAdapterPort = pedidoRepositoryAdapterPort;
    }

    @Override
    public List<Pedido> executar(LocalDate dataCriacao) {
        return pedidoRepositoryAdapterPort.pesquisarPorDataCriacao(dataCriacao);
    }
}
