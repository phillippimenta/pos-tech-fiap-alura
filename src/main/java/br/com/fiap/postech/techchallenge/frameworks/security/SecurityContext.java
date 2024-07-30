package br.com.fiap.postech.techchallenge.frameworks.security;

import br.com.fiap.postech.techchallenge.domain.entities.Cliente;
import br.com.fiap.postech.techchallenge.domain.ports.output.ClienteRepositoryPort;
import br.com.fiap.postech.techchallenge.domain.ports.output.SecurityContextPort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityContext implements SecurityContextPort {

    private final ClienteRepositoryPort clienteRepositoryAdapter;

    public SecurityContext(ClienteRepositoryPort clienteRepositoryAdapter) {
        this.clienteRepositoryAdapter = clienteRepositoryAdapter;
    }

    @Override
    public Cliente obterClienteAutenticado() {
        Long clienteId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return this.clienteRepositoryAdapter.obterPorId(clienteId);
    }
}
