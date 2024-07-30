package br.com.fiap.postech.techchallenge.domain.ports.input;

import br.com.fiap.postech.techchallenge.domain.entities.Produto;

public interface AtualizarProdutoUseCasePort {

    Produto executar(Long id, Produto produtoAtualizado);
}
