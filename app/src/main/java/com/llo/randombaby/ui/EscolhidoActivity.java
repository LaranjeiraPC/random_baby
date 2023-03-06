package com.llo.randombaby.ui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.llo.randombaby.R;
import com.llo.randombaby.enums.GeneroEnum;

public class EscolhidoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolhido);

        MediaPlayer musicClaps = MediaPlayer.create(EscolhidoActivity.this, R.raw.claps);
        musicClaps.start();

        Bundle txtBundle = getIntent().getExtras();
        final String genero = txtBundle.getString("genero");
        final String nomeEscolhidoTemp = txtBundle.getString("nomeEscolhido");

        TextView nomeEscolhido = findViewById(R.id.nomeEscolhido);
        if (GeneroEnum.MASCULINO.name().equals(genero)) {
            nomeEscolhido.setText(nomeEscolhidoTemp);
        } else {
            nomeEscolhido.setText(nomeEscolhidoTemp);
        }

        ImageView voltar = findViewById(R.id.buttonVoltar);
        voltar.setOnClickListener(view -> {
            musicClaps.stop();
            Intent intent = new Intent(EscolhidoActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}