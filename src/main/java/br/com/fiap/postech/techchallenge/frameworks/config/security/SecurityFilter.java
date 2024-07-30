package br.com.fiap.postech.techchallenge.frameworks.config.security;

import br.com.fiap.postech.techchallenge.domain.ports.output.JsonWebTokenPort;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final JsonWebTokenPort jsonWebTokenPort;

    public SecurityFilter(
            JsonWebTokenPort jsonWebTokenPort) {
        this.jsonWebTokenPort = jsonWebTokenPort;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        String tokenJWT = recuperarToken(request);
        if (tokenJWT != null) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(jsonWebTokenPort.recuperarClienteToken(tokenJWT).getId(), null, List.of());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }
        return null;
    }
}
