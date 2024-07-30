package br.com.fiap.postech.techchallenge.frameworks.web.rest;

import br.com.fiap.postech.techchallenge.adapters.controllers.PedidoController;
import br.com.fiap.postech.techchallenge.adapters.controllers.request.PedidoRequest;
import br.com.fiap.postech.techchallenge.adapters.controllers.response.PedidoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Pedidos", description = "Operações relacionadas a pedidos.")
@RestController
@RequestMapping("/pedidos")
public class PedidoRestController {

    private final PedidoController pedidoController;

    public PedidoRestController(PedidoController pedidoController) {
        this.pedidoController = pedidoController;
    }

    @Operation(summary = "Permite cadastrar um novo pedido.")
    @Transactional
    @PostMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<PedidoResponse> criarPedido(@RequestBody @Valid PedidoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.pedidoController.cadastrarPedido(request));
    }
}
