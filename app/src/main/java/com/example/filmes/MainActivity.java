package com.example.filmes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private List<Foto> fotos;
    private List<String> descricoes;
    private int atual;
    private TextView textView;
    private ImageButton imageButton;

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

        fotos = new ArrayList<>();

        Foto foto1 = new Foto(R.drawable.aorigem, descricoes.get(0));
        Foto foto2 = new Foto(R.drawable.interestelar, descricoes.get(1));
        Foto foto3 = new Foto(R.drawable.perdidoemmarte, descricoes.get(2));
        Foto foto4 = new Foto(R.drawable.ateoultimohomem, descricoes.get(3));
        Foto foto5 = new Foto(R.drawable.vingadoresultimato, descricoes.get(4));

        fotos.add(foto1);
        fotos.add(foto2);
        fotos.add(foto3);
        fotos.add(foto4);
        fotos.add(foto5);

        atual = 0;

        textView = findViewById(R.id.textoImagem);
        textView.setText(fotos.get(atual).getDescricao());

        imageButton = findViewById(R.id.btn_like);
    }

    public void avance(View view) {
//        atual = (atual + 1) % fotos.size(); // 0 1 2 3 4

        if (atual == fotos.size() - 1) {
            atual = 0;
        } else {
            atual++;
        } // 0 1 2 3 4


        imageView.setImageResource(fotos.get(atual).getId());
        textView.setText(fotos.get(atual).getDescricao());
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

        imageView.setImageResource(fotos.get(atual).getId());
        textView.setText(fotos.get(atual).getDescricao());
        recarregueLike();
    }

    private void recarregueLike() {
        Foto fotoAtual = fotos.get(atual);

        if (fotoAtual.isLike()) {
            imageButton.setImageResource(R.drawable.like_on);
        } else {
            imageButton.setImageResource(R.drawable.like_off);
        }
    }

    public void likeDeslike(View view) {
        Foto fotoAtual = fotos.get(atual);
        if (fotoAtual.isLike()) {
            fotoAtual.setLike(false);
            imageButton.setImageResource(R.drawable.like_off);
        } else {
            fotoAtual.setLike(true);
            imageButton.setImageResource(R.drawable.like_on);
        }
    }
}