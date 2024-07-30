package br.com.fiap.postech.techchallenge.domain.exception;

import java.util.List;

public class DominioException extends RuntimeException {

    public DominioException(String mensagem) {
        super(mensagem);
    }

    public DominioException(List<String> mensagens) {
        super(String.join(", ", mensagens));
    }
}
