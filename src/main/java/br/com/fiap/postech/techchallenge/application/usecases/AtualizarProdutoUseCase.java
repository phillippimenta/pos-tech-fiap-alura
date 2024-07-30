package br.com.fiap.postech.techchallenge.application.usecases;

import br.com.fiap.postech.techchallenge.domain.entities.Produto;
import br.com.fiap.postech.techchallenge.domain.exception.DominioException;
import br.com.fiap.postech.techchallenge.domain.ports.input.AtualizarProdutoUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.output.ProdutoRepositoryPort;

public class AtualizarProdutoUseCase implements AtualizarProdutoUseCasePort {

    private final ProdutoRepositoryPort produtoRepositoryPort;

    public AtualizarProdutoUseCase(ProdutoRepositoryPort produtoRepositoryPort) {
        this.produtoRepositoryPort = produtoRepositoryPort;
    }

    @Override
    public Produto executar(Long id, Produto produtoAtualizado) {
        Produto produtoEncontrado = this.produtoRepositoryPort.obterPorId(id);
        if (produtoEncontrado == null) {
            String mensagem = String.format("Produto %s não encontrado.", id);
            throw new DominioException(mensagem);
        }
        produtoEncontrado.atualizarCom(produtoAtualizado);
        return this.produtoRepositoryPort.salvar(produtoEncontrado);
    }
}
