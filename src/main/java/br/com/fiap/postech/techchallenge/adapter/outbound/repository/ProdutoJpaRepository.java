package br.com.fiap.postech.techchallenge.adapter.outbound.repository;

import br.com.fiap.postech.techchallenge.adapter.outbound.repository.entity.ProdutoEntity;
import br.com.fiap.postech.techchallenge.application.domain.CategoriaEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoJpaRepository extends JpaRepository<ProdutoEntity, Long> {

    List<ProdutoEntity> findByCategoria(CategoriaEnum categoria);

    ProdutoEntity findByNomeIgnoreCase(String nome);
}
