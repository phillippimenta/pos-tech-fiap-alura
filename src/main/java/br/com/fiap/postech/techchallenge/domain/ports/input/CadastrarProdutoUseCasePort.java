package br.com.fiap.postech.techchallenge.domain.ports.input;

import br.com.fiap.postech.techchallenge.domain.entities.Produto;

public interface CadastrarProdutoUseCasePort {

    Produto executar(Produto produto);
}
