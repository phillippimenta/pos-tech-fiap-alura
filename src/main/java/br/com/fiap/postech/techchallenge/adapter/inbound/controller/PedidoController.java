package br.com.fiap.postech.techchallenge.adapter.inbound.controller;

import br.com.fiap.postech.techchallenge.adapter.inbound.controller.request.CriarPedidoRequest;
import br.com.fiap.postech.techchallenge.adapter.inbound.controller.response.PedidoResponse;
import br.com.fiap.postech.techchallenge.application.domain.Pedido;
import br.com.fiap.postech.techchallenge.application.port.inbound.CriarPedidoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.EntregarPedidoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.FinalizarPreparacaoPedidoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.PagarPedidoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.PrepararPedidoUseCasePort;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final CriarPedidoUseCasePort criarPedidoUseCasePort;

    private final PagarPedidoUseCasePort pagarPedidoUseCasePort;

    private final PrepararPedidoUseCasePort prepararPedidoUseCasePort;

    private final FinalizarPreparacaoPedidoUseCasePort finalizarPreparacaoPedidoUseCasePort;

    private final EntregarPedidoUseCasePort entregarPedidoUseCasePort;

    public PedidoController(
            CriarPedidoUseCasePort criarPedidoUseCasePort,
            PagarPedidoUseCasePort pagarPedidoUseCasePort,
            PrepararPedidoUseCasePort prepararPedidoUseCasePort,
            FinalizarPreparacaoPedidoUseCasePort finalizarPreparacaoPedidoUseCasePort,
            EntregarPedidoUseCasePort entregarPedidoUseCasePort
    ) {
        this.criarPedidoUseCasePort = criarPedidoUseCasePort;
        this.pagarPedidoUseCasePort = pagarPedidoUseCasePort;
        this.prepararPedidoUseCasePort = prepararPedidoUseCasePort;
        this.finalizarPreparacaoPedidoUseCasePort = finalizarPreparacaoPedidoUseCasePort;
        this.entregarPedidoUseCasePort = entregarPedidoUseCasePort;
    }

    @Transactional
    @PostMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<PedidoResponse> criarPedido(@RequestBody @Valid CriarPedidoRequest request) {
        Pedido pedido = this.criarPedidoUseCasePort.executar(CriarPedidoRequest.toPedido(request));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(PedidoResponse.fromPedidoResponse(pedido));
    }

    @Transactional
    @PatchMapping("/{id}/pagar")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<PedidoResponse> pagarPedido(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(PedidoResponse.fromPedidoResponse(this.pagarPedidoUseCasePort.executar(id)));
    }

    @Transactional
    @PatchMapping("/{id}/preparar")
    public ResponseEntity<PedidoResponse> prepararPedido(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(PedidoResponse.fromPedidoResponse(this.prepararPedidoUseCasePort.executar(id)));
    }

    @Transactional
    @PatchMapping("/{id}/pronto")
    public ResponseEntity<PedidoResponse> finalizarPreparacaoPedido(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(PedidoResponse.fromPedidoResponse(this.finalizarPreparacaoPedidoUseCasePort.executar(id)));
    }

    @Transactional
    @PatchMapping("/{id}/entregar")
    public ResponseEntity<PedidoResponse> entregarPedido(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(PedidoResponse.fromPedidoResponse(this.entregarPedidoUseCasePort.executar(id)));
    }
}
