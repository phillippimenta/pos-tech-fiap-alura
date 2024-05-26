package br.com.fiap.postech.techchallenge.config;

import br.com.fiap.postech.techchallenge.application.port.inbound.*;
import br.com.fiap.postech.techchallenge.application.port.outbound.ClienteRepositoryAdapterPort;
import br.com.fiap.postech.techchallenge.application.port.outbound.ProdutoRepositoryAdapterPort;
import br.com.fiap.postech.techchallenge.application.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CadastrarClienteUseCasePort cadastrarClienteUseCase(ClienteRepositoryAdapterPort clienteRepositoryAdapterPort) {
        return new CadastrarClienteUseCase(clienteRepositoryAdapterPort);
    }

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
