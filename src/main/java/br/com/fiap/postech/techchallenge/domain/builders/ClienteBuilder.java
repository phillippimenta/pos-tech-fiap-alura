package br.com.fiap.postech.techchallenge.domain.builders;

import br.com.fiap.postech.techchallenge.domain.entities.CPF;
import br.com.fiap.postech.techchallenge.domain.entities.Cliente;
import br.com.fiap.postech.techchallenge.domain.entities.Email;

public class ClienteBuilder {

    private Cliente cliente;

    public ClienteBuilder() {
        this.cliente = new Cliente();
    }

    public ClienteBuilder id(Long id) {
        this.cliente.setId(id);
        return this;
    }

    public ClienteBuilder cpf(CPF cpf) {
        this.cliente.setCpf(cpf);
        return this;
    }

    public ClienteBuilder nome(String nome) {
        this.cliente.setNome(nome);
        return this;
    }

    public ClienteBuilder email(Email email) {
        this.cliente.setEmail(email);
        return this;
    }

    public ClienteBuilder anonimo(Boolean anonimo) {
        this.cliente.setAnonimo(anonimo);
        return this;
    }

    public Cliente build() {
        return this.cliente;
    }
}
