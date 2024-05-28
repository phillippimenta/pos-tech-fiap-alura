package br.com.fiap.postech.techchallenge.application.usecase;

import br.com.fiap.postech.techchallenge.application.domain.Pedido;
import br.com.fiap.postech.techchallenge.application.domain.StatusPedido;
import br.com.fiap.postech.techchallenge.application.exception.DominioException;
import br.com.fiap.postech.techchallenge.application.port.inbound.PrepararPedidoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.outbound.PedidoRepositoryAdapterPort;

import java.util.Objects;

public class PrepararPedidoUseCase implements PrepararPedidoUseCasePort {

    private final PedidoRepositoryAdapterPort pedidoRepositoryAdapterPort;

    public PrepararPedidoUseCase(PedidoRepositoryAdapterPort pedidoRepositoryAdapterPort) {
        this.pedidoRepositoryAdapterPort = pedidoRepositoryAdapterPort;
    }

    @Override
    public Pedido executar(Long id) {
        Pedido pedido = pedidoRepositoryAdapterPort.obterPorId(id);
        if (pedido == null || !Objects.equals(pedido.getStatus(), StatusPedido.PAGAMENTO_CONFIRMADO)) {
            String mensagem = String.format("Pedido %s não encontrado.", id);
            throw new DominioException(mensagem);
        }
        pedido.setStatus(StatusPedido.EM_PREPARACAO);
        return pedidoRepositoryAdapterPort.salvar(pedido);
    }
}
