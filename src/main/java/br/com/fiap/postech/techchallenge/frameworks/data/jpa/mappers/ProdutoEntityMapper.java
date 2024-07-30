package br.com.fiap.postech.techchallenge.frameworks.data.jpa.mappers;

import br.com.fiap.postech.techchallenge.domain.entities.Produto;
import br.com.fiap.postech.techchallenge.frameworks.data.jpa.entities.ProdutoEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoEntityMapper {

    public Produto convertDomain(ProdutoEntity entity) {
        if (entity == null) return null;
        Produto produto = new Produto();
        produto.setId(entity.getId());
        produto.setCategoria(entity.getCategoria());
        produto.setNome(entity.getNome());
        produto.setDescricao(entity.getDescricao());
        produto.setPreco(entity.getPreco());
        return produto;
    }

    public List<Produto> convertDomainList(List<ProdutoEntity> entityList) {
        if (entityList == null) return List.of();
        return entityList.stream().map(this::convertDomain).collect(Collectors.toList());
    }

    public ProdutoEntity convertEntity(Produto produto) {
        if (produto == null) return null;
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setCategoria(produto.getCategoria());
        produtoEntity.setId(produto.getId());
        produtoEntity.setNome(produto.getNome());
        produtoEntity.setDescricao(produto.getDescricao());
        produtoEntity.setPreco(produto.getPreco());
        return produtoEntity;
    }

    public List<ProdutoEntity> convertEntityList(List<Produto> produtoList) {
        if (produtoList == null) return List.of();
        return produtoList.stream().map(this::convertEntity).collect(Collectors.toList());
    }
}
