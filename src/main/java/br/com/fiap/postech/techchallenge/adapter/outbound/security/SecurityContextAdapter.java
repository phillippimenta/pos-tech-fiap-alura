package br.com.fiap.postech.techchallenge.adapter.outbound.security;

import br.com.fiap.postech.techchallenge.application.domain.Cliente;
import br.com.fiap.postech.techchallenge.application.port.outbound.ClienteRepositoryAdapterPort;
import br.com.fiap.postech.techchallenge.application.port.outbound.SecurityContextAdapterPort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityContextAdapter implements SecurityContextAdapterPort {

    private final ClienteRepositoryAdapterPort clienteRepositoryAdapter;

    public SecurityContextAdapter(ClienteRepositoryAdapterPort clienteRepositoryAdapter) {
        this.clienteRepositoryAdapter = clienteRepositoryAdapter;
    }

    @Override
    public Cliente obterClienteAutenticado() {
        Long clienteId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return this.clienteRepositoryAdapter.obterPorId(clienteId);
    }
}
