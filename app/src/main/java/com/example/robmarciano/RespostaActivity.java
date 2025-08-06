package com.example.robmarciano;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class RespostaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);

        TextView campoResposta = findViewById(R.id.textViewResposta);
        String respostaRecebida = getIntent().getStringExtra("resposta");

        campoResposta.setText(respostaRecebida != null ? respostaRecebida : "Sem resposta gerada.");

        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(RespostaActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // encerra a RespostaActivity para evitar empilhamento
        });

    }

}
