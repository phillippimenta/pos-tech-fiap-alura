package br.com.fiap.postech.techchallenge.application.usecase;

import br.com.fiap.postech.techchallenge.application.domain.Produto;
import br.com.fiap.postech.techchallenge.application.exception.DominioException;
import br.com.fiap.postech.techchallenge.application.port.inbound.RemoverProdutoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.outbound.ProdutoRepositoryAdapterPort;

public class RemoverProdutoUseCase implements RemoverProdutoUseCasePort {

    private final ProdutoRepositoryAdapterPort produtoRepositoryAdapterPort;

    public RemoverProdutoUseCase(ProdutoRepositoryAdapterPort produtoRepositoryAdapterPort) {
        this.produtoRepositoryAdapterPort = produtoRepositoryAdapterPort;
    }

    @Override
    public void executar(String nome) {
        Produto produtoEncontrado = this.produtoRepositoryAdapterPort.obterPorNome(nome);
        if (produtoEncontrado == null) {
            String mensagem = String.format("Produto %s não encontrado.", nome);
            throw new DominioException(mensagem);
        }
        produtoRepositoryAdapterPort.deletar(produtoEncontrado.getId());
    }
}
