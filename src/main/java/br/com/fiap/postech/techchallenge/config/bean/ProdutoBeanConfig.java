package br.com.fiap.postech.techchallenge.config.bean;

import br.com.fiap.postech.techchallenge.application.port.inbound.AtualizarProdutoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.CriarProdutoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.PesquisarPorCategoriaUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.RemoverProdutoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.outbound.ProdutoRepositoryAdapterPort;
import br.com.fiap.postech.techchallenge.application.usecase.AtualizarProdutoUseCase;
import br.com.fiap.postech.techchallenge.application.usecase.CriarProdutoUseCase;
import br.com.fiap.postech.techchallenge.application.usecase.PesquisarPorCategoriaUseCase;
import br.com.fiap.postech.techchallenge.application.usecase.RemoverProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutoBeanConfig {

    @Bean
    public PesquisarPorCategoriaUseCasePort pesquisarPorCategoriaUseCase(ProdutoRepositoryAdapterPort produtoRepositoryAdapterPort) {
        return new PesquisarPorCategoriaUseCase(produtoRepositoryAdapterPort);
    }

    @Bean
    public CriarProdutoUseCasePort criarProdutoUseCasePort(ProdutoRepositoryAdapterPort produtoRepositoryAdapterPort) {
        return new CriarProdutoUseCase(produtoRepositoryAdapterPort);
    }

    @Bean
    public AtualizarProdutoUseCasePort atualizarProdutoUseCasePort(ProdutoRepositoryAdapterPort produtoRepositoryAdapterPort) {
        return new AtualizarProdutoUseCase(produtoRepositoryAdapterPort);
    }

    @Bean
    public RemoverProdutoUseCasePort removerProdutoUseCasePort(ProdutoRepositoryAdapterPort produtoRepositoryAdapterPort) {
        return new RemoverProdutoUseCase(produtoRepositoryAdapterPort);
    }
}
