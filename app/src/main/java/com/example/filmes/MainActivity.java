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
    private List<Filme> filmes;
    private List<String> descricoes;
    private List<Integer> idsVideo;
    private List<Integer> idsVideoHD;
    private int atual;
    private TextView textView;
    private ImageButton imageButton;
    private TextView titulo;
    private Switch HD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicialize();
    }

    private void inicialize() {
        imageView = findViewById(R.id.imagem);

        descricoes = new ArrayList<>();

        descricoes.add("Em um mundo onde é possível entrar na mente humana, Cobb (Leonardo DiCaprio) está entre os melhores na arte de roubar segredos valiosos do inconsciente, durante o estado de sono. Além disto ele é um fugitivo, pois está impedido de retornar aos Estados Unidos devido à morte de Mal (Marion Cotillard). Desesperado para rever seus filhos, Cobb aceita a ousada missão proposta por Saito (Ken Watanabe), um empresário japonês: entrar na mente de Richard Fischer (Cillian Murphy), o herdeiro de um império econômico, e plantar a ideia de desmembrá-lo.");
        descricoes.add("Após ver a Terra consumindo boa parte de suas reservas naturais, um grupo de astronautas recebe a missão de verificar possíveis planetas para receberem a população mundial, possibilitando a continuação da espécie. Cooper (Matthew McConaughey) é chamado para liderar o grupo e aceita a missão sabendo que pode nunca mais ver os filhos. Ao lado de Brand (Anne Hathaway), Jenkins (Marlon Sanders) e Doyle (Wes Bentley), ele seguirá em busca de uma nova casa.");
        descricoes.add("O astronauta Mark Watney (Matt Damon) é enviado a uma missão em Marte. Após uma severa tempestade ele é dado como morto, abandonado pelos colegas e acorda sozinho no misterioso planeta com escassos suprimentos, sem saber como reencontrar os companheiros ou retornar à Terra.");
        descricoes.add("Em Até o Último Homem, durante a Segunda Guerra Mundial, o médico do exército Desmond T. Doss (Andrew Garfield) se recusa a pegar em uma arma e matar pessoas, porém, durante a Batalha de Okinawa ele trabalha na ala médica e salva mais de 75 homens, sendo condecorado. O que faz de Doss o primeiro Opositor Consciente da história norte-americana a receber a Medalha de Honra do Congresso.");
        descricoes.add("Em Vingadores: Ultimato, após Thanos eliminar metade das criaturas vivas em Vingadores: Guerra Infinita, os heróis precisam lidar com a dor da perda de amigos e seus entes queridos. Com Tony Stark (Robert Downey Jr.) vagando perdido no espaço sem água nem comida, o Capitão América/Steve Rogers (Chris Evans) e a Viúva Negra/Natasha Romanov (Scarlett Johansson) precisam liderar a resistência contra o titã louco.");

        idsVideo = new ArrayList<>();

        idsVideo.add(R.raw.aorigem);
        idsVideo.add(R.raw.interestelar);
        idsVideo.add(R.raw.perdidoemmarte);
        idsVideo.add(R.raw.ateoultimohomem);
        idsVideo.add(R.raw.vingadoresultimato);

        idsVideoHD = new ArrayList<>();

        idsVideoHD.add(R.raw.aorigemhd);
        idsVideoHD.add(R.raw.interestelarhd);
        idsVideoHD.add(R.raw.perdidoemmartehd);
        idsVideoHD.add(R.raw.ateoultimohomemhd);
        idsVideoHD.add(R.raw.vingadoresultimatohd);

        filmes = new ArrayList<>();

        Filme filme1 = new Filme(R.drawable.aorigem, descricoes.get(0), "A origem");
        Filme filme2 = new Filme(R.drawable.interestelar, descricoes.get(1), "Interestelar");
        Filme filme3 = new Filme(R.drawable.perdidoemmarte, descricoes.get(2), "Perdido em marte");
        Filme filme4 = new Filme(R.drawable.ateoultimohomem, descricoes.get(3), "Até o último homem");
        Filme filme5 = new Filme(R.drawable.vingadoresultimato, descricoes.get(4), "Vingadores ultimato");

        filmes.add(filme1);
        filmes.add(filme2);
        filmes.add(filme3);
        filmes.add(filme4);
        filmes.add(filme5);

        atual = 0;

        textView = findViewById(R.id.textoImagem);
        imageButton = findViewById(R.id.btn_like);
        titulo = findViewById(R.id.titulo);
        HD = findViewById(R.id.HD);

        carregar();
    }

    public void avance(View view) {
//        atual = (atual + 1) % fotos.size(); // 0 1 2 3 4

        if (atual == filmes.size() - 1) {
            atual = 0;
        } else {
            atual++;
        } // 0 1 2 3 4

        carregar();
        recarregueLike();
    }

    public void volte(View view) {
//        atual = (atual < 0) ? 0 : atual - 1; // 4 3 2 1 0
        // atual = pergunta ? verdade : falsidade;
        if (atual == 0) {
            atual = 4;
        } else {
            atual = atual - 1; // atual--;
        }

        carregar();
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

    private void carregar() {
        imageView.setImageResource(filmes.get(atual).getId());
        textView.setText(filmes.get(atual).getDescricao());
        titulo.setText(filmes.get(atual).getTitulo());
    }

    public void verTrailer(View view) {
        Intent it = new Intent(this, PlayerActivity.class);
        int idVideo = idsVideo.get(atual);

        if(HD.isChecked()) {
            idVideo = idsVideoHD.get(atual);
        }

        it.putExtra("idVideo", idVideo);
        startActivity(it);
    }
}