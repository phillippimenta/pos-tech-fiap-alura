package br.com.fiap.postech.techchallenge.domain.ports.input;

import br.com.fiap.postech.techchallenge.domain.entities.Pedido;

import java.time.LocalDate;
import java.util.List;

public interface ListarPedidosPorDataCriacaoUseCasePort {

    List<Pedido> executar(LocalDate dataCriacao);
}
