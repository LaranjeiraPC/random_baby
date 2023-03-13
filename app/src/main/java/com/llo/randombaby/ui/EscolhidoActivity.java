package com.llo.randombaby.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.llo.randombaby.R;
import com.llo.randombaby.enums.GeneroEnum;

public class EscolhidoActivity extends AppCompatActivity {

    private ImageView idRandomFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolhido);

        MediaPlayer musicClaps = MediaPlayer.create(EscolhidoActivity.this, R.raw.claps);
        musicClaps.start();

        Bundle txtBundle = getIntent().getExtras();
        final String genero = txtBundle.getString("genero");
        final String nomeEscolhidoTemp = txtBundle.getString("nomeEscolhido");
        final String foto = txtBundle.getString("foto");

        TextView nomeEscolhido = findViewById(R.id.nomeEscolhido);
        if (GeneroEnum.MASCULINO.name().equals(genero)) {
            nomeEscolhido.setText(nomeEscolhidoTemp);
        } else {
            nomeEscolhido.setText(nomeEscolhidoTemp);
        }

        idRandomFoto = findViewById(R.id.idRandomFoto);
        Resources res = this.getResources();

        switch (foto) {
            case "1": {
                idRandomFoto.setImageDrawable(ResourcesCompat.getDrawable(res, R.drawable.babyboy, null));
                break;
            }
            case "2": {
                idRandomFoto.setImageDrawable(ResourcesCompat.getDrawable(res, R.drawable.babycute, null));
                break;
            }
            case "3": {
                idRandomFoto.setImageDrawable(ResourcesCompat.getDrawable(res, R.drawable.babyugly, null));
                break;
            }
            default:
                idRandomFoto.setImageDrawable(ResourcesCompat.getDrawable(res, R.drawable.babyugly, null));
                break;
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