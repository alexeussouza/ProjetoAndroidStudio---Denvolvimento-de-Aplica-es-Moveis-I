package com.example.robmarciano;

import java.util.Locale;

public class Robo {
    private Mensageiro mensageiro;

    public Robo(Mensageiro mensageiro) {
        this.mensageiro = mensageiro;
    }

    public void responder(String frase) {
        if (frase == null || frase.trim().isEmpty()) {
            mensageiro.exibirMensagem("Não me incomode");
            return;
        }

        frase = frase.trim();
        boolean ehPergunta = frase.endsWith("?");
        boolean temEu = frase.toLowerCase().contains("eu");

        boolean temGrito = false;
        for (String palavra : frase.split("\\s+")) {
            // Remove pontuação
            String limpa = palavra.replaceAll("[^\\p{L}]", "");

            // Testa se contém letras e está inteiramente em maiúsculas
            if (!limpa.isEmpty() &&
                    limpa.equals(limpa.toUpperCase(Locale.ROOT)) &&
                    limpa.matches(".*\\p{Lu}+.*")) {
                temGrito = true;
                break;
            }
        }


        if (temGrito && ehPergunta) {
            mensageiro.exibirMensagem("Relaxa, eu sei o que estou fazendo!");
        } else if (ehPergunta) {
            mensageiro.exibirMensagem("Certamente");
        } else if (temGrito) {
            mensageiro.exibirMensagem("Opa! Calma ai!");
        } else if (temEu) {
            mensageiro.exibirMensagem("A responsabilidade é sua");
        } else {
            mensageiro.exibirMensagem("Tudo bem, como quiser");
        }
    }
}

