package br.com.fiap.postech.techchallenge.application.port.outbound;

import br.com.fiap.postech.techchallenge.application.domain.CategoriaEnum;
import br.com.fiap.postech.techchallenge.application.domain.Produto;

import java.util.List;

public interface ProdutoRepositoryAdapterPort {

    List<Produto> pesquisarPorCategoria(CategoriaEnum categoria);

    Produto obterPorNome(String nome);

    Produto salvar(Produto produto);

    void deletar(Long id);
}
