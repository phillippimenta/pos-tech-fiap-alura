package br.com.fiap.postech.techchallenge.adapters.controllers;

import br.com.fiap.postech.techchallenge.adapters.controllers.request.AutenticarClienteRequest;
import br.com.fiap.postech.techchallenge.adapters.controllers.request.ClienteRequest;
import br.com.fiap.postech.techchallenge.adapters.controllers.response.ClienteResponse;
import br.com.fiap.postech.techchallenge.application.services.ClienteService;
import br.com.fiap.postech.techchallenge.domain.entities.CPF;
import br.com.fiap.postech.techchallenge.domain.entities.Cliente;
import br.com.fiap.postech.techchallenge.domain.entities.DadosTokenJWT;

import java.util.List;

public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public List<ClienteResponse> listarClientesComFiltroPorCPF(String cpf) {
        return ClienteResponse.fromList(this.clienteService.listarClientesComFiltroPorCPF(cpf));
    }

    public ClienteResponse cadastrarCliente(ClienteRequest request) {
        Cliente cliente = ClienteRequest.to(request);
        return ClienteResponse.from(this.clienteService.cadastrarCliente(cliente));
    }

    public DadosTokenJWT autenticarPorCPF(AutenticarClienteRequest request) {
        return this.clienteService.autenticarClientePorCPF(new CPF(request.cpf()));
    }

    public DadosTokenJWT autenticarAnonimo() {
        return this.clienteService.autenticarClienteAnonimo();
    }
}