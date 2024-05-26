package br.com.fiap.postech.techchallenge.application.usecase;

import br.com.fiap.postech.techchallenge.application.domain.Produto;
import br.com.fiap.postech.techchallenge.application.exception.DominioException;
import br.com.fiap.postech.techchallenge.application.port.inbound.CriarProdutoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.outbound.ProdutoRepositoryAdapterPort;

public class CriarProdutoUseCase implements CriarProdutoUseCasePort {

    private final ProdutoRepositoryAdapterPort produtoRepositoryAdapterPort;

    public CriarProdutoUseCase(ProdutoRepositoryAdapterPort produtoRepositoryAdapterPort) {
        this.produtoRepositoryAdapterPort = produtoRepositoryAdapterPort;
    }

    @Override
    public Produto executar(Produto produto) {
        Produto produtoPesquisado = this.produtoRepositoryAdapterPort.obterPorNome(produto.getNome());
        if (produtoPesquisado != null) {
            String mensagem = String.format("Produto %s já cadastrado.", produto.getNome());
            throw new DominioException(mensagem);
        }
        return this.produtoRepositoryAdapterPort.salvar(produto);
    }
}
