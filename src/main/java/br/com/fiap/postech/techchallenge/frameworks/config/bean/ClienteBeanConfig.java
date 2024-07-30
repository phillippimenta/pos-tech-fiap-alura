package br.com.fiap.postech.techchallenge.frameworks.config.bean;

import br.com.fiap.postech.techchallenge.adapters.controllers.ClienteController;
import br.com.fiap.postech.techchallenge.application.services.ClienteService;
import br.com.fiap.postech.techchallenge.application.usecases.AutenticarClienteAnonimoUseCase;
import br.com.fiap.postech.techchallenge.application.usecases.AutenticarClientePorCPFUseCase;
import br.com.fiap.postech.techchallenge.application.usecases.CadastrarClienteUseCase;
import br.com.fiap.postech.techchallenge.application.usecases.ListarClientesUseCase;
import br.com.fiap.postech.techchallenge.domain.ports.input.AutenticarClienteAnonimoUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.input.AutenticarClientePorCPFUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.input.CadastrarClienteUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.input.ListarClientesUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.output.ClienteRepositoryPort;
import br.com.fiap.postech.techchallenge.domain.ports.output.JsonWebTokenPort;
import br.com.fiap.postech.techchallenge.frameworks.data.jpa.ClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteBeanConfig {

    @Bean
    public ListarClientesUseCasePort listarClientesUseCasePort(ClienteRepository clienteRepositoryAdapter) {
        return new ListarClientesUseCase(clienteRepositoryAdapter);
    }

    @Bean
    public CadastrarClienteUseCasePort cadastrarClienteUseCasePort(ClienteRepository clienteRepositoryAdapter) {
        return new CadastrarClienteUseCase(clienteRepositoryAdapter);
    }

    @Bean
    public AutenticarClientePorCPFUseCasePort autenticarClientePorCPFUseCasePort(
            ClienteRepositoryPort clienteRepositoryPort,
            JsonWebTokenPort jsonWebTokenPort
    ) {
        return new AutenticarClientePorCPFUseCase(clienteRepositoryPort, jsonWebTokenPort);
    }

    @Bean
    public AutenticarClienteAnonimoUseCasePort autenticarClienteAnonimoUseCasePort(
            ClienteRepositoryPort clienteRepositoryPort,
            JsonWebTokenPort jsonWebTokenPort
    ) {
        return new AutenticarClienteAnonimoUseCase(clienteRepositoryPort, jsonWebTokenPort);
    }

    @Bean
    public ClienteService clienteService(
            ListarClientesUseCasePort listarClientesUseCasePort,
            CadastrarClienteUseCasePort cadastrarClienteUseCasePort,
            AutenticarClientePorCPFUseCasePort autenticarClientePorCPFUseCasePort,
            AutenticarClienteAnonimoUseCasePort autenticarClienteAnonimoUseCasePort
    ) {
        return new ClienteService(
                listarClientesUseCasePort,
                cadastrarClienteUseCasePort,
                autenticarClientePorCPFUseCasePort,
                autenticarClienteAnonimoUseCasePort
        );
    }

    @Bean
    public ClienteController clienteController(ClienteService clienteService) {
        return new ClienteController(clienteService);
    }
}
