package br.com.fiap.postech.techchallenge.frameworks.web.rest;

import br.com.fiap.postech.techchallenge.adapters.controllers.ProdutoController;
import br.com.fiap.postech.techchallenge.adapters.controllers.request.ProdutoRequest;
import br.com.fiap.postech.techchallenge.adapters.controllers.response.ProdutoResponse;
import br.com.fiap.postech.techchallenge.domain.enums.CategoriaProduto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Produtos", description = "Operações relacionadas a produtos.")
@RestController
@RequestMapping("/produtos")
public class ProdutoRestController {

    private final ProdutoController produtoController;

    public ProdutoRestController(ProdutoController produtoController) {
        this.produtoController = produtoController;
    }

    @Operation(summary = "Permite pesquisar produtos a partir da categoria.")
    @ApiResponse(responseCode = "200", description = "Listagem de produtos encontrados")
    @GetMapping("/{categoriaProduto}")
    public ResponseEntity<List<ProdutoResponse>> pesquisarProdutoPorCategoria(@PathVariable CategoriaProduto categoriaProduto) {
        return ResponseEntity.status(HttpStatus.OK).body(this.produtoController.pesquisarProdutoPorCategoria(categoriaProduto));
    }

    @Operation(summary = "Permite cadastrar um novo produto")
    @ApiResponse(responseCode = "201", description = "Produto criado com sucesso")
    @PostMapping
    public ResponseEntity<ProdutoResponse> criarProduto(@RequestBody @Valid ProdutoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.produtoController.cadastrarProduto(request));
    }

    @Operation(summary = "Permite atualizar os dados de um produto.")
    @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso")
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizarProduto(@PathVariable Long id, @Valid @RequestBody ProdutoRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(this.produtoController.atualizarProduto(id, request));
    }

    @Operation(summary = "Permite remover um produto")
    @ApiResponse(responseCode = "204", description = "Produto deletado com sucesso")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoController.removerProduto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
