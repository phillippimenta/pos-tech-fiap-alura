package br.com.fiap.postech.techchallenge.application.services;

import br.com.fiap.postech.techchallenge.domain.entities.Pedido;
import br.com.fiap.postech.techchallenge.domain.enums.StatusPedido;
import br.com.fiap.postech.techchallenge.domain.ports.input.AlterarStatusPedidoUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.input.CadastrarPedidoUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.input.ListarPedidosPorDataCriacaoUseCasePort;

import java.time.LocalDate;
import java.util.List;

public class PedidoService {

    private final CadastrarPedidoUseCasePort cadastrarPedidoUseCasePort;

    private final ListarPedidosPorDataCriacaoUseCasePort listarPedidosPorDataCriacaoUseCasePort;

    private final AlterarStatusPedidoUseCasePort alterarStatusPedidoUseCasePort;

    public PedidoService(
            CadastrarPedidoUseCasePort cadastrarPedidoUseCasePort,
            ListarPedidosPorDataCriacaoUseCasePort listarPedidosPorDataCriacaoUseCasePort,
            AlterarStatusPedidoUseCasePort alterarStatusPedidoUseCasePort
    ) {
        this.cadastrarPedidoUseCasePort = cadastrarPedidoUseCasePort;
        this.listarPedidosPorDataCriacaoUseCasePort = listarPedidosPorDataCriacaoUseCasePort;
        this.alterarStatusPedidoUseCasePort = alterarStatusPedidoUseCasePort;
    }

    public Pedido cadastrarPedido(Pedido pedido) {
        return this.cadastrarPedidoUseCasePort.executar(pedido);
    }

    public List<Pedido> listarPedidosPorDataCriacao(LocalDate dataCriacao) {
        return this.listarPedidosPorDataCriacaoUseCasePort.executar(dataCriacao);
    }

    public Pedido alterarStatusPedido(Long pedidoId, StatusPedido novoStatus) {
        return this.alterarStatusPedidoUseCasePort.executar(pedidoId, novoStatus);
    }
}
