package br.com.fiap.postech.techchallenge.application.usecase;

import br.com.fiap.postech.techchallenge.application.domain.TipoProduto;
import br.com.fiap.postech.techchallenge.application.domain.Produto;
import br.com.fiap.postech.techchallenge.application.port.inbound.PesquisarPorCategoriaUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.outbound.ProdutoRepositoryAdapterPort;

import java.util.List;

public class PesquisarPorCategoriaUseCase implements PesquisarPorCategoriaUseCasePort {

    private final ProdutoRepositoryAdapterPort produtoRepositoryAdapterPort;

    public PesquisarPorCategoriaUseCase(ProdutoRepositoryAdapterPort produtoRepositoryAdapterPort) {
        this.produtoRepositoryAdapterPort = produtoRepositoryAdapterPort;
    }

    @Override
    public List<Produto> executar(TipoProduto categoria) {
        return this.produtoRepositoryAdapterPort.pesquisarPorTipoProduto(categoria);
    }
}
