package br.com.fiap.postech.techchallenge.application.services;

import br.com.fiap.postech.techchallenge.domain.entities.Produto;
import br.com.fiap.postech.techchallenge.domain.enums.CategoriaProduto;
import br.com.fiap.postech.techchallenge.domain.ports.input.AtualizarProdutoUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.input.CadastrarProdutoUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.input.PesquisarProdutoPorCategoriaUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.input.RemoverProdutoUseCasePort;

import java.util.List;

public class ProdutoService {

    private final CadastrarProdutoUseCasePort cadastrarProdutoUseCasePort;

    private final AtualizarProdutoUseCasePort atualizarProdutoUseCasePort;

    private final RemoverProdutoUseCasePort removerProdutoUseCasePort;

    private final PesquisarProdutoPorCategoriaUseCasePort pesquisarProdutoPorCategoriaUseCasePort;

    public ProdutoService(
            CadastrarProdutoUseCasePort cadastrarProdutoUseCasePort,
            AtualizarProdutoUseCasePort atualizarProdutoUseCasePort,
            RemoverProdutoUseCasePort removerProdutoUseCasePort,
            PesquisarProdutoPorCategoriaUseCasePort pesquisarProdutoPorCategoriaUseCasePort
    ) {
        this.cadastrarProdutoUseCasePort = cadastrarProdutoUseCasePort;
        this.atualizarProdutoUseCasePort = atualizarProdutoUseCasePort;
        this.removerProdutoUseCasePort = removerProdutoUseCasePort;
        this.pesquisarProdutoPorCategoriaUseCasePort = pesquisarProdutoPorCategoriaUseCasePort;
    }

    public List<Produto> pesquisarProdutoPorCategoria(CategoriaProduto categoria) {
        return this.pesquisarProdutoPorCategoriaUseCasePort.executar(categoria);
    }

    public Produto cadastrarProduto(Produto produto) {
        return this.cadastrarProdutoUseCasePort.executar(produto);
    }

    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        return this.atualizarProdutoUseCasePort.executar(id, produtoAtualizado);
    }

    public void removerProduto(Long id) {
        this.removerProdutoUseCasePort.executar(id);
    }
}
