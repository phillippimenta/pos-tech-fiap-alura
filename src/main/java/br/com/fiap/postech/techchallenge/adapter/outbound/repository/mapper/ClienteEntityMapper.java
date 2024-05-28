package br.com.fiap.postech.techchallenge.adapter.outbound.repository.mapper;

import br.com.fiap.postech.techchallenge.adapter.outbound.repository.entity.ClienteEntity;
import br.com.fiap.postech.techchallenge.application.domain.CPF;
import br.com.fiap.postech.techchallenge.application.domain.Cliente;
import br.com.fiap.postech.techchallenge.application.domain.Email;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteEntityMapper {

    public Cliente toCliente(ClienteEntity entity) {
        if (entity == null) return null;
        Cliente cliente = new Cliente();
        cliente.setId(entity.getId());
        cliente.setNome(entity.getNome());
        cliente.setCpf(entity.getCpf() == null ? null : new CPF(entity.getCpf()));
        cliente.setEmail(entity.getEmail() == null ? null : new Email(entity.getEmail()));
        cliente.setAnonimo(entity.getAnonimo());
        return cliente;
    }

    public List<Cliente> toClienteList(List<ClienteEntity> entityList) {
        if (entityList == null) return List.of();
        return entityList.stream().map(this::toCliente).collect(Collectors.toList());
    }

    public ClienteEntity toClienteEntity(Cliente cliente) {
        if (cliente == null) return null;
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setId(cliente.getId());
        clienteEntity.setNome(cliente.getNome());
        clienteEntity.setCpf(cliente.getCpf() == null ? null : cliente.getCpf().getNumero());
        clienteEntity.setEmail(cliente.getEmail() == null ? null : cliente.getEmail().getEndereco());
        clienteEntity.setAnonimo(cliente.getAnonimo());
        return clienteEntity;
    }

    public List<ClienteEntity> toClienteEntityList(List<Cliente> clienteList) {
        if (clienteList == null) return List.of();
        return clienteList.stream().map(this::toClienteEntity).collect(Collectors.toList());
    }
}
