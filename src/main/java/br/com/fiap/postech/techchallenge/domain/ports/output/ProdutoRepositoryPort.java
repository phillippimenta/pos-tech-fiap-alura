package br.com.fiap.postech.techchallenge.domain.ports.output;

import br.com.fiap.postech.techchallenge.domain.entities.Produto;
import br.com.fiap.postech.techchallenge.domain.enums.CategoriaProduto;

import java.util.List;

public interface ProdutoRepositoryPort {

    List<Produto> pesquisarPorTipoProduto(CategoriaProduto categoriaProduto);

    Produto obterPorId(Long id);

    Produto obterPorNome(String nome);

    Produto salvar(Produto produto);

    void deletar(Long id);
}
