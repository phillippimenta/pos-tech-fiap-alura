package br.com.fiap.postech.techchallenge.application.usecases;

import br.com.fiap.postech.techchallenge.domain.entities.Pedido;
import br.com.fiap.postech.techchallenge.domain.enums.StatusPedido;
import br.com.fiap.postech.techchallenge.domain.ports.input.AlterarStatusPedidoUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.output.PedidoRepositoryPort;

public class AlterarStatusPedidoUseCase implements AlterarStatusPedidoUseCasePort {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    public AlterarStatusPedidoUseCase(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }

    @Override
    public Pedido executar(Long pedidoId, StatusPedido novoStatus) {
        Pedido pedido = pedidoRepositoryPort.obterPorId(pedidoId);
        pedido.alterarStatus(novoStatus);
        return this.pedidoRepositoryPort.salvar(pedido);
    }
}
