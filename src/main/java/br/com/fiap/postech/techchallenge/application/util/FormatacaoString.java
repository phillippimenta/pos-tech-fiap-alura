package br.com.fiap.postech.techchallenge.application.util;

public class FormatacaoString {

    public static String somenteNumeros(String valor) {
        if (valor == null) {
            return null;
        }
        return valor.replaceAll("[^0-9]", "");
    }
}
