package br.com.fiap.postech.techchallenge.application.port.inbound;

import br.com.fiap.postech.techchallenge.application.domain.TipoProduto;
import br.com.fiap.postech.techchallenge.application.domain.Produto;

import java.util.List;

public interface PesquisarPorCategoriaUseCasePort {

    List<Produto> executar(TipoProduto categoria);
}
