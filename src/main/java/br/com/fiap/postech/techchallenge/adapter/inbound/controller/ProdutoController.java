package br.com.fiap.postech.techchallenge.adapter.inbound.controller;

import br.com.fiap.postech.techchallenge.adapter.inbound.controller.request.CriarProdutoRequest;
import br.com.fiap.postech.techchallenge.adapter.inbound.controller.response.ProdutoResponse;
import br.com.fiap.postech.techchallenge.application.domain.TipoProduto;
import br.com.fiap.postech.techchallenge.application.domain.Produto;
import br.com.fiap.postech.techchallenge.application.port.inbound.AtualizarProdutoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.CriarProdutoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.PesquisarPorCategoriaUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.RemoverProdutoUseCasePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@SecurityRequirement(name = "bearer-key")
public class ProdutoController {

    private final PesquisarPorCategoriaUseCasePort pesquisarPorCategoriaUseCasePort;

    private final CriarProdutoUseCasePort criarProdutoUseCasePort;

    private final AtualizarProdutoUseCasePort atualizarProdutoUseCasePort;

    private final RemoverProdutoUseCasePort removerProdutoUseCasePort;

    public ProdutoController(PesquisarPorCategoriaUseCasePort pesquisarPorCategoriaUseCasePort,
                             CriarProdutoUseCasePort criarProdutoUseCasePort,
                             AtualizarProdutoUseCasePort atualizarProdutoUseCasePort,
                             RemoverProdutoUseCasePort removerProdutoUseCasePort) {
        this.pesquisarPorCategoriaUseCasePort = pesquisarPorCategoriaUseCasePort;
        this.criarProdutoUseCasePort = criarProdutoUseCasePort;
        this.atualizarProdutoUseCasePort = atualizarProdutoUseCasePort;
        this.removerProdutoUseCasePort = removerProdutoUseCasePort;
    }

    @Operation(summary = "Lista de produtos encontrados")
    @ApiResponse(responseCode = "200", description = "Listagem de produtos encontrados")
    @GetMapping("/{tipoProduto}")
    public ResponseEntity<List<ProdutoResponse>> pesquisarProdutoPorCategoria(@PathVariable TipoProduto tipoProduto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ProdutoResponse.fromProdutoResponseList(this.pesquisarPorCategoriaUseCasePort.executar(tipoProduto)));
    }

    @Operation(summary = "Criar um novo produto")
    @ApiResponse(responseCode = "201", description = "Produto criado com sucesso")
    @PostMapping
    public ResponseEntity<ProdutoResponse> criarProduto(@RequestBody @Valid CriarProdutoRequest request) {
        Produto produto = CriarProdutoRequest.toProduto(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProdutoResponse.fromProdutoResponse(this.criarProdutoUseCasePort.executar(produto)));
    }

    @Operation(summary = "Atualizar um produto")
    @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso")
    @PutMapping("/{nome}")
    public ResponseEntity<ProdutoResponse> atualizarProduto(@PathVariable String nome, @Valid @RequestBody CriarProdutoRequest request) {
        Produto produto = CriarProdutoRequest.toProduto(request);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ProdutoResponse.fromProdutoResponse(this.atualizarProdutoUseCasePort.executar(nome, produto)));
    }

    @Operation(summary = "Remover um produto")
    @ApiResponse(responseCode = "204", description = "Produto deletado com sucesso")
    @DeleteMapping("/{nome}")
    public ResponseEntity<Void> deletarProduto(@PathVariable String nome) {
        removerProdutoUseCasePort.executar(nome);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
