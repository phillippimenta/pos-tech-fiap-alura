package br.com.fiap.postech.techchallenge.frameworks.data.jpa;

import br.com.fiap.postech.techchallenge.domain.entities.CPF;
import br.com.fiap.postech.techchallenge.domain.entities.Cliente;
import br.com.fiap.postech.techchallenge.domain.ports.output.ClienteRepositoryPort;
import br.com.fiap.postech.techchallenge.frameworks.data.jpa.entities.ClienteEntity;
import br.com.fiap.postech.techchallenge.frameworks.data.jpa.mappers.ClienteEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository implements ClienteRepositoryPort {

    private final ClienteJpaRepository clienteJpaRepository;

    private final ClienteEntityMapper clienteEntityMapper;

    public ClienteRepository(
            ClienteJpaRepository clienteJpaRepository,
            ClienteEntityMapper clienteEntityMapper
    ) {
        this.clienteJpaRepository = clienteJpaRepository;
        this.clienteEntityMapper = clienteEntityMapper;
    }

    @Override
    public List<Cliente> listar() {
        return this.clienteEntityMapper.convertDomainList(this.clienteJpaRepository.findAll());
    }

    @Override
    public Cliente obterPorId(Long id) {
        ClienteEntity clienteEntity = this.clienteJpaRepository.obterPorId(id);
        return this.clienteEntityMapper.convertDomain(clienteEntity);
    }

    @Override
    public Cliente obterPorCPF(CPF cpf) {
        ClienteEntity clienteEntity = this.clienteJpaRepository.obterPorCpf(cpf.getNumero());
        return this.clienteEntityMapper.convertDomain(clienteEntity);
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        ClienteEntity clienteEntity = this.clienteJpaRepository.save(this.clienteEntityMapper.convertEntity(cliente));
        return this.clienteEntityMapper.convertDomain(clienteEntity);
    }
}
