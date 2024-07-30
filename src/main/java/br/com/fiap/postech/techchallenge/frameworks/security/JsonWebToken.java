package br.com.fiap.postech.techchallenge.frameworks.security;

import br.com.fiap.postech.techchallenge.domain.entities.Cliente;
import br.com.fiap.postech.techchallenge.domain.entities.DadosTokenJWT;
import br.com.fiap.postech.techchallenge.domain.ports.output.JsonWebTokenPort;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class JsonWebToken implements JsonWebTokenPort {

    public static final String API_PROJETO_TECH_CHALLENGE = "API Projeto Tech Challenge";

    @Value("${app.jwt.secret}")
    private String secret;

    @Override
    public DadosTokenJWT gerarToken(Cliente cliente) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return new DadosTokenJWT(JWT.create()
                    .withIssuer(API_PROJETO_TECH_CHALLENGE)
                    .withSubject(cliente.getId().toString())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo));
        } catch (JWTCreationException exception) {
            throw new RuntimeException("erro ao gerar token jwt", exception);
        }
    }

    @Override
    public Cliente recuperarClienteToken(String tokenJWT) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            Long clienteId = Long.valueOf(JWT.require(algoritmo)
                    .withIssuer(API_PROJETO_TECH_CHALLENGE)
                    .build()
                    .verify(tokenJWT)
                    .getSubject());
            Cliente cliente = new Cliente();
            cliente.setId(clienteId);
            return cliente;
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }
}
