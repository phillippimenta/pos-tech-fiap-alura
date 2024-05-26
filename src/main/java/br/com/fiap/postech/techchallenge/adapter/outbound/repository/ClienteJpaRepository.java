package br.com.fiap.postech.techchallenge.adapter.outbound.repository;

import br.com.fiap.postech.techchallenge.adapter.outbound.repository.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, Long> {

    ClienteEntity findByCpf(String cpf);
}
