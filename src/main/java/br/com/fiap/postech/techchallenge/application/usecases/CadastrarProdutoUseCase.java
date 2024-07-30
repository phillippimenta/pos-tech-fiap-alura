package br.com.fiap.postech.techchallenge.application.usecases;

import br.com.fiap.postech.techchallenge.domain.entities.Produto;
import br.com.fiap.postech.techchallenge.domain.exception.DominioException;
import br.com.fiap.postech.techchallenge.domain.ports.input.CadastrarProdutoUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.output.ProdutoRepositoryPort;

public class CadastrarProdutoUseCase implements CadastrarProdutoUseCasePort {

    private final ProdutoRepositoryPort produtoRepositoryPort;

    public CadastrarProdutoUseCase(ProdutoRepositoryPort produtoRepositoryPort) {
        this.produtoRepositoryPort = produtoRepositoryPort;
    }

    @Override
    public Produto executar(Produto produto) {
        Produto produtoPesquisado = this.produtoRepositoryPort.obterPorNome(produto.getNome());
        if (produtoPesquisado != null) {
            String mensagem = String.format("Produto %s já cadastrado.", produto.getNome());
            throw new DominioException(mensagem);
        }
        return this.produtoRepositoryPort.salvar(produto);
    }
}
