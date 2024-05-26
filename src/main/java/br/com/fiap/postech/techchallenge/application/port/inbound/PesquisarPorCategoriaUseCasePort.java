package br.com.fiap.postech.techchallenge.application.port.inbound;

import br.com.fiap.postech.techchallenge.application.domain.CategoriaEnum;
import br.com.fiap.postech.techchallenge.application.domain.Produto;

import java.util.List;

public interface PesquisarPorCategoriaUseCasePort {

    List<Produto> executar(CategoriaEnum categoria);
}
