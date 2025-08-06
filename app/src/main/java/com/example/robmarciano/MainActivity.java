package com.example.robmarciano;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.time.LocalDateTime;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    public void respostasMarciano(View view) {
        EditText frase = findViewById(R.id.txt_pergunta);
        String comando = frase.getText().toString().toLowerCase(Locale.ROOT);

        // Buffer pra guardar a resposta
        final String[] respostaFinal = {""};

        Mensageiro mensageiro = texto -> respostaFinal[0] = texto;

        Premium acaoHora = () -> {
            String texto = "Executando ação premium... A hora atual é: " + LocalDateTime.now();
            respostaFinal[0] = texto;
        };

        RoboPremium marciano = new RoboPremium(acaoHora, mensageiro);
        RoboMatematico calculista = new RoboMatematico(mensageiro);

        if (comando.isEmpty()) {
            respostaFinal[0] = "Você precisa digitar uma frase!";
        } else if (comando.startsWith("some") || comando.startsWith("subtraia") ||
                comando.startsWith("multiplique") || comando.startsWith("divida")) {

            String[] partes = comando.split(" ");
            if (partes.length == 3) {
                try {
                    double x = Double.parseDouble(partes[1]);
                    double y = Double.parseDouble(partes[2]);
                    calculista.calcular(partes[0], x, y);
                } catch (NumberFormatException e) {
                    respostaFinal[0] = "❌ Números inválidos.";
                }
            } else {
                respostaFinal[0] = "⚠️ Formato esperado: operação número número";
            }
        } else {
            marciano.responder(comando);
        }

        // Envia a resposta para a nova activity
        Intent intent = new Intent(this, RespostaActivity.class);
        intent.putExtra("resposta", respostaFinal[0]);
        startActivity(intent);
    }

}