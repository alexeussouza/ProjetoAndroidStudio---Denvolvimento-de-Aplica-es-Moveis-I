package com.example.robmarciano;

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

    public void respostasMarciano(View view){

        EditText frase = findViewById(R.id.txt_pergunta);

        Premium acaoHora = () -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Executando ação premium... A hora atual é: ");
            sb.append(LocalDateTime.now());
            frase.setText(sb.toString());
        };

        Mensageiro mensageiro = frase::setText; // exibe texto diretamente no EditText

        RoboPremium marciano = new RoboPremium(acaoHora, mensageiro);
        RoboMatematico calculista = new RoboMatematico(mensageiro);

        if (frase != null && !frase.getText().toString().isEmpty()) {
            String comando = frase.getText().toString().toLowerCase(Locale.ROOT);

            if (comando.startsWith("some") ||
                    comando.startsWith("subtraia") ||
                    comando.startsWith("multiplique") ||
                    comando.startsWith("divida")) {

                String[] partes = comando.split(" ");
                if (partes.length == 3) {
                    try {
                        double x = Double.parseDouble(partes[1]);
                        double y = Double.parseDouble(partes[2]);
                        calculista.calcular(partes[0], x, y);
                    } catch (NumberFormatException e) {
                        frase.setText("❌ Números inválidos.");
                    }
                } else {
                    frase.setText("⚠️ Formato esperado: operação número número");
                }
            } else {
                marciano.responder(comando); // resposta exibida internamente via Mensageiro
            }
        }
    }
}