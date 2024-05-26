package br.com.fiap.postech.techchallenge.application.usecase;

import br.com.fiap.postech.techchallenge.application.domain.Produto;
import br.com.fiap.postech.techchallenge.application.exception.DominioException;
import br.com.fiap.postech.techchallenge.application.port.inbound.AtualizarProdutoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.outbound.ProdutoRepositoryAdapterPort;

public class AtualizarProdutoUseCase implements AtualizarProdutoUseCasePort {

    private final ProdutoRepositoryAdapterPort produtoRepositoryAdapterPort;

    public AtualizarProdutoUseCase(ProdutoRepositoryAdapterPort produtoRepositoryAdapterPort) {
        this.produtoRepositoryAdapterPort = produtoRepositoryAdapterPort;
    }

    @Override
    public Produto executar(String nome, Produto produtoAtualizado) {
        Produto produtoEncontrado = this.produtoRepositoryAdapterPort.obterPorNome(nome);
        if (produtoEncontrado == null) {
            String mensagem = String.format("Produto %s não encontrado.", nome);
            throw new DominioException(mensagem);
        }
        produtoEncontrado.atualizarCom(produtoAtualizado);
        return this.produtoRepositoryAdapterPort.salvar(produtoEncontrado);
    }
}
