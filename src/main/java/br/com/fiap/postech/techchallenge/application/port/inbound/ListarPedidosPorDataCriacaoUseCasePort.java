package br.com.fiap.postech.techchallenge.application.port.inbound;

import br.com.fiap.postech.techchallenge.application.domain.Pedido;

import java.time.LocalDate;
import java.util.List;

public interface ListarPedidosPorDataCriacaoUseCasePort {

    List<Pedido> executar(LocalDate dataCriacao);
}
