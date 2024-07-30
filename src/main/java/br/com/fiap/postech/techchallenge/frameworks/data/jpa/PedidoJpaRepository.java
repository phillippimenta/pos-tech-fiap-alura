package br.com.fiap.postech.techchallenge.frameworks.data.jpa;

import br.com.fiap.postech.techchallenge.frameworks.data.jpa.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoJpaRepository extends JpaRepository<PedidoEntity, Long> {

    @Query("FROM PedidoEntity p WHERE p.id = :id")
    PedidoEntity obterPorId(Long id);

    @Query("FROM PedidoEntity p WHERE FUNCTION('DATE', p.dataHoraCriacao) = :dataCriacao")
    List<PedidoEntity> pesquisarPorDataCriacao(LocalDate dataCriacao);
}
