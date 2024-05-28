package br.com.fiap.postech.techchallenge.adapter.outbound.repository;

import br.com.fiap.postech.techchallenge.adapter.outbound.repository.entity.ClienteEntity;
import br.com.fiap.postech.techchallenge.adapter.outbound.repository.mapper.ClienteEntityMapper;
import br.com.fiap.postech.techchallenge.application.domain.CPF;
import br.com.fiap.postech.techchallenge.application.domain.Cliente;
import br.com.fiap.postech.techchallenge.application.port.outbound.ClienteRepositoryAdapterPort;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepositoryAdapter implements ClienteRepositoryAdapterPort {

    private final ClienteJpaRepository clienteJpaRepository;

    private final ClienteEntityMapper clienteEntityMapper;

    public ClienteRepositoryAdapter(
            ClienteJpaRepository clienteJpaRepository,
            ClienteEntityMapper clienteEntityMapper
    ) {
        this.clienteJpaRepository = clienteJpaRepository;
        this.clienteEntityMapper = clienteEntityMapper;
    }

    @Override
    public Cliente obterPorId(Long id) {
        ClienteEntity clienteEntity = this.clienteJpaRepository.obterPorId(id);
        return this.clienteEntityMapper.toCliente(clienteEntity);
    }

    @Override
    public Cliente obterPorCPF(CPF cpf) {
        ClienteEntity clienteEntity = this.clienteJpaRepository.obterPorCpf(cpf.getNumero());
        return this.clienteEntityMapper.toCliente(clienteEntity);
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        ClienteEntity clienteEntity = this.clienteJpaRepository.save(this.clienteEntityMapper.toClienteEntity(cliente));
        return this.clienteEntityMapper.toCliente(clienteEntity);
    }
}
