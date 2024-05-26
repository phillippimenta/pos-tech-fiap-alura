package br.com.fiap.postech.techchallenge.application.port.inbound;

import br.com.fiap.postech.techchallenge.application.domain.Produto;

public interface AtualizarProdutoUseCasePort {

    Produto executar(String nome, Produto produtoAtualizado);
}
