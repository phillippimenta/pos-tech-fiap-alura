package br.com.fiap.postech.techchallenge.application.usecases;

import br.com.fiap.postech.techchallenge.domain.entities.Produto;
import br.com.fiap.postech.techchallenge.domain.enums.CategoriaProduto;
import br.com.fiap.postech.techchallenge.domain.ports.input.PesquisarProdutoPorCategoriaUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.output.ProdutoRepositoryPort;

import java.util.List;

public class PesquisarProdutoPorCategoriaUseCase implements PesquisarProdutoPorCategoriaUseCasePort {

    private final ProdutoRepositoryPort produtoRepositoryPort;

    public PesquisarProdutoPorCategoriaUseCase(ProdutoRepositoryPort produtoRepositoryPort) {
        this.produtoRepositoryPort = produtoRepositoryPort;
    }

    @Override
    public List<Produto> executar(CategoriaProduto categoria) {
        return this.produtoRepositoryPort.pesquisarPorTipoProduto(categoria);
    }
}
