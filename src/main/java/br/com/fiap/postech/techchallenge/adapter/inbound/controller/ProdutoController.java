package br.com.fiap.postech.techchallenge.adapter.inbound.controller;

import br.com.fiap.postech.techchallenge.adapter.inbound.controller.response.ProdutoResponse;
import br.com.fiap.postech.techchallenge.adapter.inbound.controller.request.CriarProdutoRequest;
import br.com.fiap.postech.techchallenge.application.domain.CategoriaEnum;
import br.com.fiap.postech.techchallenge.application.domain.Produto;
import br.com.fiap.postech.techchallenge.application.port.inbound.AtualizarProdutoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.CriarProdutoUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.PesquisarPorCategoriaUseCasePort;
import br.com.fiap.postech.techchallenge.application.port.inbound.RemoverProdutoUseCasePort;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
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

    @ApiResponse(responseCode = "200", description = "Lista de produtos encontrados")
    @GetMapping("/{categoria}")
    public ResponseEntity<List<ProdutoResponse>> pesquisarProdutoPorCategoria(@PathVariable CategoriaEnum categoria) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ProdutoResponse.fromProdutoResponseList(this.pesquisarPorCategoriaUseCasePort.executar(categoria)));
    }

    @ApiResponse(responseCode = "201", description = "Produto criado com sucesso")
    @PostMapping
    public ResponseEntity<ProdutoResponse> criarProduto(@Valid @RequestBody CriarProdutoRequest request) {
        Produto produto = CriarProdutoRequest.toProduto(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProdutoResponse.fromProdutoResponse(this.criarProdutoUseCasePort.executar(produto)));
    }

    @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso")
    @PutMapping("/{nome}")
    public ResponseEntity<ProdutoResponse> atualizarProduto(@PathVariable String nome, @Valid @RequestBody CriarProdutoRequest request) {
        Produto produto = CriarProdutoRequest.toProduto(request);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ProdutoResponse.fromProdutoResponse(this.atualizarProdutoUseCasePort.executar(nome, produto)));
    }

    @ApiResponse(responseCode = "204", description = "Produto deletado com sucesso")
    @DeleteMapping("/{nome}")
    public ResponseEntity<Void> deletarProduto(@PathVariable String nome) {
        removerProdutoUseCasePort.executar(nome);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
