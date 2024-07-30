package br.com.fiap.postech.techchallenge.frameworks.config.bean;

import br.com.fiap.postech.techchallenge.adapters.controllers.ProdutoController;
import br.com.fiap.postech.techchallenge.application.services.ProdutoService;
import br.com.fiap.postech.techchallenge.application.usecases.AtualizarProdutoUseCase;
import br.com.fiap.postech.techchallenge.application.usecases.CadastrarProdutoUseCase;
import br.com.fiap.postech.techchallenge.application.usecases.PesquisarProdutoPorCategoriaUseCase;
import br.com.fiap.postech.techchallenge.application.usecases.RemoverProdutoUseCase;
import br.com.fiap.postech.techchallenge.domain.ports.input.AtualizarProdutoUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.input.CadastrarProdutoUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.input.PesquisarProdutoPorCategoriaUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.input.RemoverProdutoUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.output.ProdutoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutoBeanConfig {

    @Bean
    public ProdutoController produtoController(
            ProdutoService produtoService
    ) {
        return new ProdutoController(produtoService);
    }

    @Bean
    public ProdutoService produtoService(
            CadastrarProdutoUseCasePort cadastrarProdutoUseCasePort,
            AtualizarProdutoUseCasePort atualizarProdutoUseCasePort,
            RemoverProdutoUseCasePort removerProdutoUseCasePort,
            PesquisarProdutoPorCategoriaUseCasePort pesquisarProdutoPorCategoriaUseCasePort
    ) {
        return new ProdutoService(
                cadastrarProdutoUseCasePort,
                atualizarProdutoUseCasePort,
                removerProdutoUseCasePort,
                pesquisarProdutoPorCategoriaUseCasePort
        );
    }

    @Bean
    public PesquisarProdutoPorCategoriaUseCasePort pesquisarProdutoPorCategoriaUseCasePort(
            ProdutoRepositoryPort produtoRepositoryPort
    ) {
        return new PesquisarProdutoPorCategoriaUseCase(produtoRepositoryPort);
    }

    @Bean
    public CadastrarProdutoUseCasePort cadastrarProdutoUseCasePort(
            ProdutoRepositoryPort produtoRepositoryPort
    ) {
        return new CadastrarProdutoUseCase(produtoRepositoryPort);
    }

    @Bean
    public AtualizarProdutoUseCasePort atualizarProdutoUseCasePort(
            ProdutoRepositoryPort produtoRepositoryPort
    ) {
        return new AtualizarProdutoUseCase(produtoRepositoryPort);
    }

    @Bean
    public RemoverProdutoUseCasePort removerProdutoUseCasePort(
            ProdutoRepositoryPort produtoRepositoryPort
    ) {
        return new RemoverProdutoUseCase(produtoRepositoryPort);
    }
}
