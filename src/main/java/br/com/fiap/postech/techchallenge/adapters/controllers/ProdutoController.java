package br.com.fiap.postech.techchallenge.adapters.controllers;

import br.com.fiap.postech.techchallenge.adapters.controllers.request.ProdutoRequest;
import br.com.fiap.postech.techchallenge.adapters.controllers.response.ProdutoResponse;
import br.com.fiap.postech.techchallenge.application.services.ProdutoService;
import br.com.fiap.postech.techchallenge.domain.entities.Produto;
import br.com.fiap.postech.techchallenge.domain.enums.CategoriaProduto;

import java.util.List;

public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public List<ProdutoResponse> pesquisarProdutoPorCategoria(CategoriaProduto categoriaProduto) {
        return ProdutoResponse.fromList(this.produtoService.pesquisarProdutoPorCategoria(categoriaProduto));
    }

    public ProdutoResponse cadastrarProduto(ProdutoRequest request) {
        Produto produto = ProdutoRequest.to(request);
        return ProdutoResponse.from(this.produtoService.cadastrarProduto(produto));
    }

    public ProdutoResponse atualizarProduto(Long id, ProdutoRequest request) {
        Produto produtoAtualizado = ProdutoRequest.to(request);
        return ProdutoResponse.from(this.produtoService.atualizarProduto(id, produtoAtualizado));
    }

    public void removerProduto(Long id) {
        this.produtoService.removerProduto(id);
    }
}
