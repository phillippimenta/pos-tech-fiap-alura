package br.com.fiap.postech.techchallenge.frameworks.data.jpa;

import br.com.fiap.postech.techchallenge.domain.enums.CategoriaProduto;
import br.com.fiap.postech.techchallenge.frameworks.data.jpa.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoJpaRepository extends JpaRepository<ProdutoEntity, Long> {

    List<ProdutoEntity> findByCategoria(CategoriaProduto categoria);

    ProdutoEntity findByNomeIgnoreCase(String nome);
}
