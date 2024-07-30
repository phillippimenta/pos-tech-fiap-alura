package br.com.fiap.postech.techchallenge.domain.ports.input;

import br.com.fiap.postech.techchallenge.domain.entities.Produto;
import br.com.fiap.postech.techchallenge.domain.enums.CategoriaProduto;

import java.util.List;

public interface PesquisarProdutoPorCategoriaUseCasePort {

    List<Produto> executar(CategoriaProduto categoria);
}
