package br.com.fiap.postech.techchallenge.frameworks.data.jpa;

import br.com.fiap.postech.techchallenge.domain.entities.Produto;
import br.com.fiap.postech.techchallenge.domain.enums.CategoriaProduto;
import br.com.fiap.postech.techchallenge.domain.ports.output.ProdutoRepositoryPort;
import br.com.fiap.postech.techchallenge.frameworks.data.jpa.entities.ProdutoEntity;
import br.com.fiap.postech.techchallenge.frameworks.data.jpa.mappers.ProdutoEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepository implements ProdutoRepositoryPort {

    private final ProdutoJpaRepository produtoJpaRepository;

    private final ProdutoEntityMapper mapper;

    public ProdutoRepository(ProdutoJpaRepository produtoJpaRepository, ProdutoEntityMapper mapper) {
        this.produtoJpaRepository = produtoJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Produto> pesquisarPorTipoProduto(CategoriaProduto categoriaProduto) {
        return this.mapper.convertDomainList(this.produtoJpaRepository.findByCategoria(categoriaProduto));
    }

    @Override
    public Produto obterPorId(Long id) {
        Optional<ProdutoEntity> produtoEntity = this.produtoJpaRepository.findById(id);
        return produtoEntity.map(this.mapper::convertDomain).orElse(null);
    }

    @Override
    public Produto obterPorNome(String nome) {
        return this.mapper.convertDomain(this.produtoJpaRepository.findByNomeIgnoreCase(nome));
    }

    @Override
    public Produto salvar(Produto produto) {
        ProdutoEntity produtoEntity = this.mapper.convertEntity(produto);
        return this.mapper.convertDomain(this.produtoJpaRepository.save(produtoEntity));
    }

    @Override
    public void deletar(Long id) {
        this.produtoJpaRepository.deleteById(id);
    }
}
