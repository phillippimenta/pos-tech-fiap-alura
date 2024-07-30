package br.com.fiap.postech.techchallenge.frameworks.data.jpa.mappers;

import br.com.fiap.postech.techchallenge.domain.builders.ClienteBuilder;
import br.com.fiap.postech.techchallenge.domain.entities.CPF;
import br.com.fiap.postech.techchallenge.domain.entities.Cliente;
import br.com.fiap.postech.techchallenge.domain.entities.Email;
import br.com.fiap.postech.techchallenge.frameworks.data.jpa.entities.ClienteEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteEntityMapper {

    public Cliente convertDomain(ClienteEntity entity) {
        if (entity == null) return null;
        return new ClienteBuilder()
                .id(entity.getId())
                .nome(entity.getNome())
                .cpf(entity.getCpf() == null ? null : new CPF(entity.getCpf()))
                .email(entity.getEmail() == null ? null : new Email(entity.getEmail()))
                .anonimo(entity.getAnonimo())
                .build();
    }

    public List<Cliente> convertDomainList(List<ClienteEntity> entityList) {
        if (entityList == null) return List.of();
        return entityList.stream().map(this::convertDomain).collect(Collectors.toList());
    }

    public ClienteEntity convertEntity(Cliente cliente) {
        if (cliente == null) return null;
        return new ClienteEntity(
                cliente.getId(),
                cliente.getCpf() == null ? null : cliente.getCpf().getNumero(),
                cliente.getNome(),
                cliente.getEmail() == null ? null : cliente.getEmail().getEndereco(),
                cliente.getAnonimo()
        );
    }

    public List<ClienteEntity> convertEntityList(List<Cliente> clienteList) {
        if (clienteList == null) return List.of();
        return clienteList.stream().map(this::convertEntity).collect(Collectors.toList());
    }
}
