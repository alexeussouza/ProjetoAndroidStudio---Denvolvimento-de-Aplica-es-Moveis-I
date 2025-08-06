package com.example.robmarciano;

import java.util.Locale;

public class ComandoProcessor {

    public static void processar(String comando, Mensageiro mensageiro, Premium premiumAcao) {
        RoboPremium premium = new RoboPremium(premiumAcao, mensageiro);
        RoboMatematico calculista = new RoboMatematico(mensageiro);

        if (comando != null && !comando.isEmpty()) {
            String texto = comando.toLowerCase(Locale.ROOT);

            if (texto.startsWith("some") ||
                    texto.startsWith("subtraia") ||
                    texto.startsWith("multiplique") ||
                    texto.startsWith("divida")) {

                String[] partes = texto.split(" ");
                if (partes.length == 3) {
                    try {
                        double x = Double.parseDouble(partes[1]);
                        double y = Double.parseDouble(partes[2]);
                        calculista.calcular(partes[0], x, y);
                    } catch (NumberFormatException e) {
                        mensageiro.exibirMensagem("❌ Números inválidos.");
                    }
                } else {
                    mensageiro.exibirMensagem("⚠️ Formato esperado: operação número número");
                }
            } else {
                premium.responder(texto);
            }
        } else {
            mensageiro.exibirMensagem("⚠️ Digite uma frase válida.");
        }
    }
}
