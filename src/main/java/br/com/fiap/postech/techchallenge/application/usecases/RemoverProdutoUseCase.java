package br.com.fiap.postech.techchallenge.application.usecases;

import br.com.fiap.postech.techchallenge.domain.entities.Produto;
import br.com.fiap.postech.techchallenge.domain.exception.DominioException;
import br.com.fiap.postech.techchallenge.domain.ports.input.RemoverProdutoUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.output.ProdutoRepositoryPort;

public class RemoverProdutoUseCase implements RemoverProdutoUseCasePort {

    private final ProdutoRepositoryPort produtoRepositoryPort;

    public RemoverProdutoUseCase(ProdutoRepositoryPort produtoRepositoryPort) {
        this.produtoRepositoryPort = produtoRepositoryPort;
    }

    @Override
    public void executar(Long id) {
        Produto produtoEncontrado = this.produtoRepositoryPort.obterPorId(id);
        if (produtoEncontrado == null) {
            String mensagem = String.format("Produto %s não encontrado.", id);
            throw new DominioException(mensagem);
        }
        produtoRepositoryPort.deletar(produtoEncontrado.getId());
    }
}
