package br.com.fiap.postech.techchallenge.config.security;

import br.com.fiap.postech.techchallenge.application.port.outbound.JsonWebTokenAdapterPort;
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

    private final JsonWebTokenAdapterPort jsonWebTokenAdapterPort;

    public SecurityFilter(
            JsonWebTokenAdapterPort jsonWebTokenAdapterPort) {
        this.jsonWebTokenAdapterPort = jsonWebTokenAdapterPort;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        String tokenJWT = recuperarToken(request);
        if (tokenJWT != null) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(jsonWebTokenAdapterPort.recuperarClienteToken(tokenJWT).getId(), null, List.of());
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
