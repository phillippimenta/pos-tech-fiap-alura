package br.com.fiap.postech.techchallenge.domain.entities;

public class DadosTokenJWT {

    private String token;

    public DadosTokenJWT(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
