package br.com.fiap.postech.techchallenge.application.port.inbound;

import br.com.fiap.postech.techchallenge.application.domain.Produto;

public interface CriarProdutoUseCasePort {

    Produto executar(Produto produto);
}
