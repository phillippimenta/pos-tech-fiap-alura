package br.com.fiap.postech.techchallenge.adapter.inbound.controller;

import br.com.fiap.postech.techchallenge.adapter.inbound.controller.request.AutenticarClienteRequest;
import br.com.fiap.postech.techchallenge.adapter.inbound.controller.request.CadastrarClienteRequest;
import br.com.fiap.postech.techchallenge.adapter.inbound.controller.response.ClienteResponse;
import br.com.fiap.postech.techchallenge.application.domain.CPF;
import br.com.fiap.postech.techchallenge.application.domain.Cliente;
import br.com.fiap.postech.techchallenge.application.domain.DadosTokenJWT;
import br.com.fiap.postech.techchallenge.application.port.inbound.AutenticarClienteAnonimoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.AutenticarClientePorCPFUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.CadastrarClienteUseCasePort;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final CadastrarClienteUseCasePort cadastrarClienteUseCasePort;

    private final AutenticarClientePorCPFUseCasePort autenticarClientePorCPFUseCasePort;

    private final AutenticarClienteAnonimoUseCasePort autenticarClienteAnonimoUseCasePort;

    public ClienteController(
            CadastrarClienteUseCasePort cadastrarClienteUseCasePort,
            AutenticarClientePorCPFUseCasePort autenticarClientePorCPFUseCasePort,
            AutenticarClienteAnonimoUseCasePort autenticarClienteAnonimoUseCasePort
    ) {
        this.cadastrarClienteUseCasePort = cadastrarClienteUseCasePort;
        this.autenticarClientePorCPFUseCasePort = autenticarClientePorCPFUseCasePort;
        this.autenticarClienteAnonimoUseCasePort = autenticarClienteAnonimoUseCasePort;
    }

    @ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso")
    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrarCliente(@Valid @RequestBody CadastrarClienteRequest request) {
        Cliente cliente = CadastrarClienteRequest.toCliente(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ClienteResponse.fromClienteResponse(this.cadastrarClienteUseCasePort.executar(cliente)));
    }

    @PostMapping("/autenticar/cpf")
    public ResponseEntity<DadosTokenJWT> autenticarPorCPF(@RequestBody AutenticarClienteRequest request) {
        DadosTokenJWT dadosTokenJWT = this.autenticarClientePorCPFUseCasePort.executar(new CPF(request.cpf()));
        return ResponseEntity.status(HttpStatus.OK).body(dadosTokenJWT);
    }

    @PostMapping("/autenticar/anonimo")
    public ResponseEntity<DadosTokenJWT> autenticarAnonimo() {
        return ResponseEntity.status(HttpStatus.OK).body(this.autenticarClienteAnonimoUseCasePort.executar());
    }
}
