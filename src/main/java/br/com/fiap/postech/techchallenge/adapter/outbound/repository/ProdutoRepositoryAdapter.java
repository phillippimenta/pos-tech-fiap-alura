package br.com.fiap.postech.techchallenge.adapter.outbound.repository;

import br.com.fiap.postech.techchallenge.adapter.outbound.repository.entity.ProdutoEntity;
import br.com.fiap.postech.techchallenge.adapter.outbound.repository.mapper.ProdutoEntityMapper;
import br.com.fiap.postech.techchallenge.application.domain.TipoProduto;
import br.com.fiap.postech.techchallenge.application.domain.Produto;
import br.com.fiap.postech.techchallenge.application.port.outbound.ProdutoRepositoryAdapterPort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepositoryAdapter implements ProdutoRepositoryAdapterPort {

    private final ProdutoJpaRepository produtoJpaRepository;

    private final ProdutoEntityMapper mapper;

    public ProdutoRepositoryAdapter(ProdutoJpaRepository produtoJpaRepository, ProdutoEntityMapper mapper) {
        this.produtoJpaRepository = produtoJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Produto> pesquisarPorTipoProduto(TipoProduto tipoProduto) {
        return this.mapper.toProdutoList(this.produtoJpaRepository.findByTipoProduto(tipoProduto));
    }

    @Override
    public Produto obterPorNome(String nome) {
        return this.mapper.toProduto(this.produtoJpaRepository.findByNomeIgnoreCase(nome));
    }

    @Override
    public Produto salvar(Produto produto) {
        ProdutoEntity produtoEntity = this.mapper.toProdutoEntity(produto);
        return this.mapper.toProduto(this.produtoJpaRepository.save(produtoEntity));
    }

    @Override
    public void deletar(Long id) {
        this.produtoJpaRepository.deleteById(id);
    }
}
