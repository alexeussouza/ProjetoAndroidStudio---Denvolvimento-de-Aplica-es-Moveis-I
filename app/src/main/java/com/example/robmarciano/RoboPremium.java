package com.example.robmarciano;

public class RoboPremium extends RoboPersonalizado {
    private Premium acaoPremium;
    private Mensageiro mensageiro;

    public RoboPremium(Premium acaoPremium, Mensageiro mensageiro) {
        super(mensageiro);
        this.acaoPremium = acaoPremium;
        this.mensageiro = mensageiro;
    }

    @Override
    public void responder(String frase) {
        if (frase.toLowerCase().contains("agir")) {
            mensageiro.exibirMensagem("É pra já!");
            acaoPremium.executarAcao();
        } else if (frase.toLowerCase().contains("dance")) {
            executarComandoPersonalizado(frase);
        } else {
            super.responder(frase);
        }
    }

    @Override
    public void executarComandoPersonalizado(String comando) {
        if (comando.toLowerCase().contains("dance")) {
            mensageiro.exibirMensagem("Dançando como uma caixa de engrenagens feliz 💃");
        } else {
            mensageiro.exibirMensagem("Comando '" + comando + "' não reconhecido.");
        }
    }
}
