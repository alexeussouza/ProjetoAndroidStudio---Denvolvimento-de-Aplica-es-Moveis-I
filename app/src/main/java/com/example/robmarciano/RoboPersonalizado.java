package com.example.robmarciano;

public class RoboPersonalizado extends Robo {
    private Mensageiro mensageiro;

    public RoboPersonalizado(Mensageiro mensageiro) {
        super(mensageiro); // 👈 Aqui está o segredo!
        this.mensageiro = mensageiro;
    }

    public void executarComandoPersonalizado(String comando) {
        if (comando.toLowerCase().contains("dance")) {
            mensageiro.exibirMensagem("Dançando como uma caixa de engrenagens feliz 💃");
        } else {
            mensageiro.exibirMensagem("Comando '" + comando + "' não reconhecido.");
        }
    }
}
