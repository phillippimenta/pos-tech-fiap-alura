package br.com.fiap.postech.techchallenge.application.usecase;

import br.com.fiap.postech.techchallenge.application.domain.Pedido;
import br.com.fiap.postech.techchallenge.application.domain.StatusPedido;
import br.com.fiap.postech.techchallenge.application.exception.DominioException;
import br.com.fiap.postech.techchallenge.application.port.inbound.FinalizarPreparacaoPedidoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.outbound.PedidoRepositoryAdapterPort;

import java.util.Objects;

public class FinalizarPreparacaoPedidoUseCase implements FinalizarPreparacaoPedidoUseCasePort {

    private final PedidoRepositoryAdapterPort pedidoRepositoryAdapterPort;

    public FinalizarPreparacaoPedidoUseCase(PedidoRepositoryAdapterPort pedidoRepositoryAdapterPort) {
        this.pedidoRepositoryAdapterPort = pedidoRepositoryAdapterPort;
    }

    @Override
    public Pedido executar(Long id) {
        Pedido pedido = pedidoRepositoryAdapterPort.obterPorId(id);
        if (pedido == null || !Objects.equals(pedido.getStatus(), StatusPedido.EM_PREPARACAO)) {
            String mensagem = String.format("Pedido %s não encontrado.", id);
            throw new DominioException(mensagem);
        }
        pedido.setStatus(StatusPedido.PRONTO);
        return pedidoRepositoryAdapterPort.salvar(pedido);
    }
}
