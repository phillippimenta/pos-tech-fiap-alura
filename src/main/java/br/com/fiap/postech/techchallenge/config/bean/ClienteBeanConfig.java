package br.com.fiap.postech.techchallenge.config.bean;

import br.com.fiap.postech.techchallenge.application.port.inbound.AutenticarClienteAnonimoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.AutenticarClientePorCPFUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.CadastrarClienteUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.outbound.ClienteRepositoryAdapterPort;
import br.com.fiap.postech.techchallenge.application.port.outbound.JsonWebTokenAdapterPort;
import br.com.fiap.postech.techchallenge.application.usecase.AutenticarClienteAnonimoUseCase;
import br.com.fiap.postech.techchallenge.application.usecase.AutenticarClientePorCPFUseCase;
import br.com.fiap.postech.techchallenge.application.usecase.CadastrarClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteBeanConfig {

    @Bean
    public AutenticarClientePorCPFUseCasePort identificarClientePorCPFUseCasePort(
            ClienteRepositoryAdapterPort clienteRepositoryAdapterPort,
            JsonWebTokenAdapterPort jsonWebTokenAdapterPort
    ) {
        return new AutenticarClientePorCPFUseCase(clienteRepositoryAdapterPort, jsonWebTokenAdapterPort);
    }

    @Bean
    public CadastrarClienteUseCasePort cadastrarClienteUseCase(ClienteRepositoryAdapterPort clienteRepositoryAdapterPort) {
        return new CadastrarClienteUseCase(clienteRepositoryAdapterPort);
    }

    @Bean
    public AutenticarClienteAnonimoUseCasePort autenticarClienteAnonimoUseCasePort(
            ClienteRepositoryAdapterPort clienteRepositoryAdapterPort,
            JsonWebTokenAdapterPort jsonWebTokenAdapterPort
    ) {
        return new AutenticarClienteAnonimoUseCase(clienteRepositoryAdapterPort, jsonWebTokenAdapterPort);
    }
}
