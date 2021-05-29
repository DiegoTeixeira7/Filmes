package com.example.filmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ImageButton imageButton;
    private TextView textView;
    private TextView titulo;
    private Switch modoHD;
    private List<Filme> filmes;
    private int atual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicialize();
    }

    private void inicialize() {
        imageView = findViewById(R.id.imagem);

        filmes = new ArrayList<>();

        Filme filme1 = new Filme(R.drawable.johnwick, R.raw.johnwick, R.raw.hdjohnwick, "John Wick (Keanu Reeves) já foi um dos assassinos mais temidos da cidade de Nova York, trabalhando em parceria com a máfia russa. Um dia, ele decide se aposentar, e neste período tem que lidar com a triste morte de sua esposa. Vítima de uma doença grave, ela já previa a sua própria morte, e deu de presente ao marido um cachorro para cuidar em seu período de luto.", "John Wick");
        Filme filme2 = new Filme(R.drawable.jogovorazes, R.raw.jogosvorazes, R.raw.hdjogosvorazes, "Num futuro distante, boa parte da população é controlada por um regime totalitário, que relembra esse domínio realizando um evento anual - e mortal - entre os 12 distritos sob sua tutela. Para salvar sua irmã caçula, a jovem Katniss Everdeen (Jennifer Lawrence) se oferece como voluntária para representar seu distrito na competição e acaba contando com a companhia de Peeta Melark.", "Jogo Vorazes");
        Filme filme3 = new Filme(R.drawable.matrix, R.raw.matrix, R.raw.hdmatrix, "Em um futuro próximo, Thomas Anderson (Keanu Reeves), um jovem programador de computador que mora em um cubículo escuro, é atormentado por estranhos pesadelos nos quais encontra-se conectado por cabos e contra sua vontade, em um imenso sistema de computadores do futuro.", "Matrix");
        Filme filme4 = new Filme(R.drawable.fragmentado, R.raw.fragmentado, R.raw.hdfragmentado, "Kevin (James McAvoy) possui 23 personalidades distintas e consegue alterná-las quimicamente em seu organismo apenas com a força do pensamento. Um dia, ele sequestra três adolescentes que encontra em um estacionamento. Vivendo em cativeiro, elas passam a conhecer as diferentes facetas de Kevin e precisam encontrar algum meio de escapar.", "Fragmentado");
        Filme filme5 = new Filme(R.drawable.hp, R.raw.hp, R.raw.hdhp, "Harry Potter (Daniel Radcliffe) é um garoto órfão de 10 anos que vive infeliz com seus tios, os Dursley. Até que, repentinamente, ele recebe uma carta contendo um convite para ingressar em Hogwarts, uma famosa escola especializada em formar jovens bruxos. Inicialmente Harry é impedido de ler a carta por seu tio Válter (Richard Griffiths), mas logo ele recebe a visita de Hagrid (Robbie Coltrane).", "Harry Potter");

        filmes.add(filme1);
        filmes.add(filme2);
        filmes.add(filme3);
        filmes.add(filme4);
        filmes.add(filme5);

        atual = 0;

        textView = findViewById(R.id.textoImagem);
        titulo = findViewById(R.id.titulo);
        imageButton = findViewById(R.id.btn_like);
        modoHD = findViewById(R.id.isHD);

        carregueFilme();
    }

    private void carregueFilme() {
        imageView.setImageResource(filmes.get(atual).getId());
        textView.setText(filmes.get(atual).getDescricao());
        titulo.setText(filmes.get(atual).getTitulo());
    }

    public void avance(View view) {
        if (atual == filmes.size() - 1) {
            atual = 0;
        } else {
            atual++;
        } // 0 1 2

        carregueFilme();
        recarregueLike();
    }

    public void volte(View view) {
        atual = (atual == 0) ? 0 : atual - 1; // 2 1 0
        // atual = pergunta ? verdade : falsidade;
        if (atual == 0) {
            atual = filmes.size() - 1;
        } else {
            atual--;
        }

        carregueFilme();
        recarregueLike();
    }

    private void recarregueLike() {
        Filme filmeAtual = filmes.get(atual);

        if (filmeAtual.isLike()) {
            imageButton.setImageResource(R.drawable.like_on);
        } else {
            imageButton.setImageResource(R.drawable.like_off);
        }
    }

    public void likeDeslike(View view) {
        Filme filmeAtual = filmes.get(atual);
        if (filmeAtual.isLike()) {
            filmeAtual.setLike(false);
            imageButton.setImageResource(R.drawable.like_off);
        } else {
            filmeAtual.setLike(true);
            imageButton.setImageResource(R.drawable.like_on);
        }
    }

    public void abrirVideo(View view) {
        Intent it = new Intent(this, PlayerActivity.class);
        it.putExtra("id", modoHD.isChecked() ? filmes.get(atual).getIdVideoHd() : filmes.get(atual).getIdVideo());
        startActivity(it);
    }
}