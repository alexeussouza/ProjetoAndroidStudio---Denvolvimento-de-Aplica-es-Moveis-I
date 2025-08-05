package com.example.robmarciano;

public class RoboMatematico extends Robo {
    private Mensageiro mensageiro;

    public RoboMatematico(Mensageiro mensageiro) {
        super(mensageiro);
        this.mensageiro = mensageiro;
    }

    public void calcular(String operacao, double x, double y) {
        String resposta;
        switch (operacao.toLowerCase()) {
            case "some":
                resposta = "Essa eu sei: " + (x + y);
                break;
            case "subtraia":
                resposta = "Essa eu sei: " + (x - y);
                break;
            case "multiplique":
                resposta = "Essa eu sei: " + (x * y);
                break;
            case "divida":
                if (y == 0) {
                    resposta = "Dividir por zero? Aí complica...";
                } else {
                    resposta = "Essa eu sei: " + (x / y);
                }
                break;
            default:
                resposta = "Não conheço essa operação.";
        }
        mensageiro.exibirMensagem(resposta);
    }
}
