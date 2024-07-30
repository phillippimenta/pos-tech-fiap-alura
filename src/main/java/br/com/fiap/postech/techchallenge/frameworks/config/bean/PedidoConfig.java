package br.com.fiap.postech.techchallenge.frameworks.config.bean;

import br.com.fiap.postech.techchallenge.adapters.controllers.PedidoController;
import br.com.fiap.postech.techchallenge.application.services.PedidoService;
import br.com.fiap.postech.techchallenge.application.usecases.CadastrarPedidoUseCase;
import br.com.fiap.postech.techchallenge.domain.ports.input.CadastrarPedidoUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.output.PedidoRepositoryPort;
import br.com.fiap.postech.techchallenge.domain.ports.output.ProdutoRepositoryPort;
import br.com.fiap.postech.techchallenge.domain.ports.output.SecurityContextPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoConfig {

    @Bean
    public PedidoController pedidoController(PedidoService pedidoService) {
        return new PedidoController(pedidoService);
    }

    @Bean
    public PedidoService pedidoService(CadastrarPedidoUseCasePort cadastrarPedidoUseCasePort) {
        return new PedidoService(cadastrarPedidoUseCasePort);
    }

    @Bean
    public CadastrarPedidoUseCasePort cadastrarPedidoUseCasePort(PedidoRepositoryPort pedidoRepositoryPort,
                                                                 ProdutoRepositoryPort produtoRepositoryPort,
                                                                 SecurityContextPort securityContextPort) {
        return new CadastrarPedidoUseCase(pedidoRepositoryPort,
                produtoRepositoryPort,
                securityContextPort);
    }
}
