package br.com.fiap.postech.techchallenge.application.port.outbound;

import br.com.fiap.postech.techchallenge.application.domain.TipoProduto;
import br.com.fiap.postech.techchallenge.application.domain.Produto;

import java.util.List;

public interface ProdutoRepositoryAdapterPort {

    List<Produto> pesquisarPorTipoProduto(TipoProduto tipoProduto);

    Produto obterPorNome(String nome);

    Produto salvar(Produto produto);

    void deletar(Long id);
}
