package br.com.fiap.postech.techchallenge.frameworks.web.rest;

import br.com.fiap.postech.techchallenge.adapters.controllers.PedidoController;
import br.com.fiap.postech.techchallenge.adapters.controllers.request.PedidoRequest;
import br.com.fiap.postech.techchallenge.adapters.controllers.response.PedidoResponse;
import br.com.fiap.postech.techchallenge.domain.enums.StatusPedido;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

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

    @Operation(summary = "Permite pesquisar pedidos com a opção de filtrar por data de criação.")
    @GetMapping
    public ResponseEntity<List<PedidoResponse>> listarPedidosPorDataCriacao(
            @Parameter(
                    description = "Data de criação no formato yyyy-MM-dd.",
                    schema = @Schema(type = "string", format = "date")
            )
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate dataCriacao
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(this.pedidoController.listarPedidosPorDataCriacao(dataCriacao));
    }

    @Operation(summary = "Permite alterar o status do pedido.")
    @Transactional
    @PatchMapping("/{pedidoId}/status/{novoStatus}")
    public ResponseEntity<PedidoResponse> alterarStatusPedido(
            @PathVariable("pedidoId") Long pedidoId,
            @PathVariable("novoStatus") StatusPedido novoStatus
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.pedidoController.alterarStatusPedido(pedidoId, novoStatus));
    }
}
