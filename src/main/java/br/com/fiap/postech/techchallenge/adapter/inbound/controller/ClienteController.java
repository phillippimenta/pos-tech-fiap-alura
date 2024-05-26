package br.com.fiap.postech.techchallenge.adapter.inbound.controller;

import br.com.fiap.postech.techchallenge.adapter.inbound.controller.request.CadastrarClienteRequest;
import br.com.fiap.postech.techchallenge.adapter.inbound.controller.request.CriarProdutoRequest;
import br.com.fiap.postech.techchallenge.adapter.inbound.controller.response.ClienteResponse;
import br.com.fiap.postech.techchallenge.adapter.inbound.controller.response.ProdutoResponse;
import br.com.fiap.postech.techchallenge.application.domain.Cliente;
import br.com.fiap.postech.techchallenge.application.domain.Produto;
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

    public ClienteController(CadastrarClienteUseCasePort cadastrarClienteUseCasePort) {
        this.cadastrarClienteUseCasePort = cadastrarClienteUseCasePort;
    }

    @ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso")
    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrarCliente(@Valid @RequestBody CadastrarClienteRequest request) {
        Cliente cliente = CadastrarClienteRequest.toCliente(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ClienteResponse.fromClienteResponse(this.cadastrarClienteUseCasePort.executar(cliente)));
    }
}
