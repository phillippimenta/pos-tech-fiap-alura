package br.com.fiap.postech.techchallenge.frameworks.web.rest;

import br.com.fiap.postech.techchallenge.adapters.controllers.ClienteController;
import br.com.fiap.postech.techchallenge.adapters.controllers.request.AutenticarClienteRequest;
import br.com.fiap.postech.techchallenge.adapters.controllers.request.ClienteRequest;
import br.com.fiap.postech.techchallenge.adapters.controllers.response.ClienteResponse;
import br.com.fiap.postech.techchallenge.domain.entities.DadosTokenJWT;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Clientes", description = "Operações relacionadas a clientes.")
@RestController
@RequestMapping("/clientes")
public class ClienteRestController {

    private final ClienteController clienteController;

    public ClienteRestController(ClienteController clienteController) {
        this.clienteController = clienteController;
    }

    @Operation(summary = "Permite pesquisar clientes com a opção de filtrar por CPF.")
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listarClientes(
            @Parameter(
                    description = "CPF no formato, com ou sem pontuação e traço.",
                    schema = @Schema(type = "string", format = "date")
            )
            @RequestParam(required = false)
            String cpf
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(this.clienteController.listarClientesComFiltroPorCPF(cpf));
    }

    @Operation(summary = "Permite cadastrar um novo cliente.")
    @ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso")
    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrarCliente(@Valid @RequestBody ClienteRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.clienteController.cadastrarCliente(request));
    }

    @Operation(summary = "Permite autenticar um cliente por CPF.")
    @PostMapping("/autenticar/cpf")
    public ResponseEntity<DadosTokenJWT> autenticarPorCPF(@RequestBody AutenticarClienteRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(this.clienteController.autenticarPorCPF(request));
    }

    @Operation(summary = "Permite autenticar um cliente sem a necessidade de identificação.")
    @PostMapping("/autenticar/anonimo")
    public ResponseEntity<DadosTokenJWT> autenticarAnonimo() {
        return ResponseEntity.status(HttpStatus.OK).body(this.clienteController.autenticarAnonimo());
    }
}
