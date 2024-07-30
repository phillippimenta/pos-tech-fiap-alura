package br.com.fiap.postech.techchallenge.domain.entities;

import br.com.fiap.postech.techchallenge.domain.exception.DominioException;
import br.com.fiap.postech.techchallenge.domain.utils.FormatacaoString;

public class CPF {

    private String numero;

    public CPF(String numero) {
        if (numero == null) {
            return;
        }
        numero = FormatacaoString.somenteNumeros(numero);
        if (!estaValido(numero)) {
            throw new DominioException("CPF inválido");
        }
        this.numero = numero;
    }

    public boolean estaValido(String numero) {
        if (numero == null || !numero.matches("\\d{11}")) {
            return false;
        }
        String cpfSemDigitosVerificadores = numero.substring(0, 9);
        int primeiroDigitoVerificador = calcularDigitoVerificador(cpfSemDigitosVerificadores);
        int segundoDigitoVerificador = calcularDigitoVerificador(
                cpfSemDigitosVerificadores + primeiroDigitoVerificador);
        int digitoVerificador1Real = Integer.parseInt(numero.substring(9, 10));
        int digitoVerificador2Real = Integer.parseInt(numero.substring(10));
        return primeiroDigitoVerificador == digitoVerificador1Real
                && segundoDigitoVerificador == digitoVerificador2Real;
    }

    private int calcularDigitoVerificador(String base) {
        int soma = 0;
        int peso = base.length() + 1;
        for (int i = 0; i < base.length(); i++) {
            soma += Character.getNumericValue(base.charAt(i)) * peso--;
        }
        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return numero;
    }

}
