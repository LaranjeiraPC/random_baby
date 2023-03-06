package com.llo.randombaby.ui;

import static java.util.Arrays.asList;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.llo.randombaby.R;
import com.llo.randombaby.enums.GeneroEnum;
import com.llo.randombaby.util.Genero;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer music = MediaPlayer.create(MainActivity.this, R.raw.ambiente);
        music.start();
        music.setLooping(true);

        final ImageView menino = findViewById(R.id.idMenino);
        menino.setOnClickListener(view -> {
            String nome = this.definirNome(Genero.meninos());
            this.carregarTelaEscolhido(GeneroEnum.MASCULINO, nome);

            music.stop();
        });

        final ImageView menina = findViewById(R.id.idMenina);
        menina.setOnClickListener(view -> {
            String nome = this.definirNome(Genero.meninas());
            this.carregarTelaEscolhido(GeneroEnum.FEMININO, nome);

            music.stop();
        });
    }

    private String definirNome(String[] genero) {
        List<String> nomes = asList(genero);
        return nomes.get(new Random().nextInt(100));
    }

    private void carregarTelaEscolhido(GeneroEnum genero, String nome) {
        Intent intent = new Intent(MainActivity.this, EscolhidoActivity.class);

        Bundle txtBundle = new Bundle();
        txtBundle.putString("nomeEscolhido", nome);
        txtBundle.putString("genero", genero.name());

        intent.putExtras(txtBundle);
        startActivity(intent);
        finish();
    }
}