package br.com.fiap.postech.techchallenge.config.bean;

import br.com.fiap.postech.techchallenge.application.port.inbound.CriarPedidoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.EntregarPedidoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.FinalizarPreparacaoPedidoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.ListarPedidosPorDataCriacaoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.PagarPedidoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.PrepararPedidoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.outbound.PedidoRepositoryAdapterPort;
import br.com.fiap.postech.techchallenge.application.port.outbound.ProdutoRepositoryAdapterPort;
import br.com.fiap.postech.techchallenge.application.port.outbound.SecurityContextAdapterPort;
import br.com.fiap.postech.techchallenge.application.usecase.CriarPedidoUseCase;
import br.com.fiap.postech.techchallenge.application.usecase.EntregarPedidoUseCase;
import br.com.fiap.postech.techchallenge.application.usecase.FinalizarPreparacaoPedidoUseCase;
import br.com.fiap.postech.techchallenge.application.usecase.ListarPedidosPorDataCriacaoUseCase;
import br.com.fiap.postech.techchallenge.application.usecase.PagarPedidoUseCase;
import br.com.fiap.postech.techchallenge.application.usecase.PrepararPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoBeanConfig {

    @Bean
    public CriarPedidoUseCasePort criarPedidoUseCase(
            PedidoRepositoryAdapterPort pedidoRepositoryAdapterPort,
            ProdutoRepositoryAdapterPort produtoRepositoryAdapterPort,
            SecurityContextAdapterPort securityContextAdapterPort
    ) {
        return new CriarPedidoUseCase(
                pedidoRepositoryAdapterPort,
                produtoRepositoryAdapterPort,
                securityContextAdapterPort
        );
    }

    @Bean
    public PagarPedidoUseCasePort pagarPedidoUseCasePort(
            PedidoRepositoryAdapterPort pedidoRepositoryAdapterPort,
            SecurityContextAdapterPort securityContextAdapterPort
    ) {
        return new PagarPedidoUseCase(pedidoRepositoryAdapterPort, securityContextAdapterPort);
    }

    @Bean
    public PrepararPedidoUseCasePort prepararPedidoUseCasePort(
            PedidoRepositoryAdapterPort pedidoRepositoryAdapterPort
    ) {
        return new PrepararPedidoUseCase(pedidoRepositoryAdapterPort);
    }

    @Bean
    public FinalizarPreparacaoPedidoUseCasePort finalizarPreparacaoPedidoUseCasePort(
            PedidoRepositoryAdapterPort pedidoRepositoryAdapterPort
    ) {
        return new FinalizarPreparacaoPedidoUseCase(pedidoRepositoryAdapterPort);
    }

    @Bean
    public EntregarPedidoUseCasePort entregarPedidoUseCasePort(
            PedidoRepositoryAdapterPort pedidoRepositoryAdapterPort
    ) {
        return new EntregarPedidoUseCase(pedidoRepositoryAdapterPort);
    }

    @Bean
    public ListarPedidosPorDataCriacaoUseCasePort listarPedidoPorDataCriacaoUseCasePort(PedidoRepositoryAdapterPort pedidoRepositoryAdapterPort) {
        return new ListarPedidosPorDataCriacaoUseCase(pedidoRepositoryAdapterPort);
    }
}
