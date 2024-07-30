package br.com.fiap.postech.techchallenge.domain.entities;

import br.com.fiap.postech.techchallenge.domain.exception.DominioException;

import java.util.Objects;

public class Email {

    private String endereco;

    public Email(String endereco) {
        if (endereco == null) {
            return;
        }
        if (!estaValido(endereco)) {
            throw new DominioException("E-mail inválido");
        }
        this.endereco = endereco;
    }

    private boolean estaValido(String endereco) {
        return endereco != null && endereco.matches("[^@]+@[^@]+\\.[a-zA-Z]{2,}");
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public int hashCode() {
        return Objects.hash(endereco);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Email other = (Email) obj;
        return Objects.equals(endereco, other.endereco);
    }

    @Override
    public String toString() {
        if (endereco == null) {
            return null;
        }
        return endereco;
    }
}
