package br.com.fiap.postech.techchallenge.application.services;

import br.com.fiap.postech.techchallenge.domain.ports.input.AutenticarClienteAnonimoUseCasePort;
import br.com.fiap.postech.techchallenge.domain.ports.input.AutenticarClientePorCPFUseCasePort;
import br.com.fiap.postech.techchallenge.domain.entities.CPF;
import br.com.fiap.postech.techchallenge.domain.ports.input.CadastrarClienteUseCasePort;
import br.com.fiap.postech.techchallenge.domain.entities.Cliente;
import br.com.fiap.postech.techchallenge.domain.entities.DadosTokenJWT;
import br.com.fiap.postech.techchallenge.domain.ports.input.ListarClientesUseCasePort;

import java.util.List;

public class ClienteService {

    private final ListarClientesUseCasePort listarClientesUseCasePort;

    private final CadastrarClienteUseCasePort cadastrarClienteUseCasePort;

    private final AutenticarClientePorCPFUseCasePort autenticarClientePorCPFUseCasePort;

    private final AutenticarClienteAnonimoUseCasePort autenticarClienteAnonimoUseCasePort;

    public ClienteService(
            ListarClientesUseCasePort listarClientesUseCasePort,
            CadastrarClienteUseCasePort cadastrarClienteUseCasePort,
            AutenticarClientePorCPFUseCasePort autenticarClientePorCPFUseCasePort,
            AutenticarClienteAnonimoUseCasePort autenticarClienteAnonimoUseCasePort
    ) {
        this.listarClientesUseCasePort = listarClientesUseCasePort;
        this.cadastrarClienteUseCasePort = cadastrarClienteUseCasePort;
        this.autenticarClientePorCPFUseCasePort = autenticarClientePorCPFUseCasePort;
        this.autenticarClienteAnonimoUseCasePort = autenticarClienteAnonimoUseCasePort;
    }

    public List<Cliente> listarClientesComFiltroPorCPF(String cpf) {
        return this.listarClientesUseCasePort.executar(cpf);
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        return this.cadastrarClienteUseCasePort.executar(cliente);
    }

    public DadosTokenJWT autenticarClientePorCPF(CPF cpf) {
        return this.autenticarClientePorCPFUseCasePort.executar(cpf);
    }

    public DadosTokenJWT autenticarClienteAnonimo() {
        return this.autenticarClienteAnonimoUseCasePort.executar();
    }
}
