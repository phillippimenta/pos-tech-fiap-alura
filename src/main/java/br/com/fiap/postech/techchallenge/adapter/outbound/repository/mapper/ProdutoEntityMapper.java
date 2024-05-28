package br.com.fiap.postech.techchallenge.adapter.outbound.repository.mapper;

import br.com.fiap.postech.techchallenge.adapter.outbound.repository.entity.ProdutoEntity;
import br.com.fiap.postech.techchallenge.application.domain.Produto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoEntityMapper {

    public Produto toProduto(ProdutoEntity entity) {
        if (entity == null) return null;
        Produto produto = new Produto();
        produto.setId(entity.getId());
        produto.setTipoProduto(entity.getTipoProduto());
        produto.setNome(entity.getNome());
        produto.setDescricao(entity.getDescricao());
        produto.setPreco(entity.getPreco());
        return produto;
    }

    public List<Produto> toProdutoList(List<ProdutoEntity> entityList) {
        if (entityList == null) return List.of();
        return entityList.stream().map(this::toProduto).collect(Collectors.toList());
    }

    public ProdutoEntity toProdutoEntity(Produto produto) {
        if (produto == null) return null;
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setTipoProduto(produto.getTipoProduto());
        produtoEntity.setId(produto.getId());
        produtoEntity.setNome(produto.getNome());
        produtoEntity.setDescricao(produto.getDescricao());
        produtoEntity.setPreco(produto.getPreco());
        return produtoEntity;
    }

    public List<ProdutoEntity> toProdutoEntityList(List<Produto> produtoList) {
        if (produtoList == null) return List.of();
        return produtoList.stream().map(this::toProdutoEntity).collect(Collectors.toList());
    }
}
