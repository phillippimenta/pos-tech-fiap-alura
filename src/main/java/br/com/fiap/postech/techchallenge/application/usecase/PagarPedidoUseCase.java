package br.com.fiap.postech.techchallenge.application.usecase;

import br.com.fiap.postech.techchallenge.application.domain.Pedido;
import br.com.fiap.postech.techchallenge.application.domain.StatusPedido;
import br.com.fiap.postech.techchallenge.application.exception.DominioException;
import br.com.fiap.postech.techchallenge.application.port.inbound.PagarPedidoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.outbound.PedidoRepositoryAdapterPort;
import br.com.fiap.postech.techchallenge.application.port.outbound.SecurityContextAdapterPort;

import java.util.Objects;

public class PagarPedidoUseCase implements PagarPedidoUseCasePort {

    private final PedidoRepositoryAdapterPort pedidoRepositoryAdapterPort;

    private final SecurityContextAdapterPort securityContextAdapterPort;

    public PagarPedidoUseCase(
            PedidoRepositoryAdapterPort pedidoRepositoryAdapterPort,
            SecurityContextAdapterPort securityContextAdapterPort
    ) {
        this.pedidoRepositoryAdapterPort = pedidoRepositoryAdapterPort;
        this.securityContextAdapterPort = securityContextAdapterPort;
    }

    @Override
    public Pedido executar(Long id) {
        Pedido pedido = pedidoRepositoryAdapterPort.obterPorId(id);
        if (pedido == null || (!Objects.equals(pedido.getStatus(), StatusPedido.RECEBIDO)
                || !Objects.equals(pedido.getCliente().getId(), this.securityContextAdapterPort.obterClienteAutenticado().getId()))) {
            String mensagem = String.format("Pedido %s não encontrado.", id);
            throw new DominioException(mensagem);
        }
        pedido.setStatus(StatusPedido.PAGAMENTO_CONFIRMADO);
        return pedidoRepositoryAdapterPort.salvar(pedido);
    }
}
