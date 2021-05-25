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

        fotos = new ArrayList<>();

        Foto foto1 = new Foto(R.drawable.johnwick, "John Wick (Keanu Reeves) já foi um dos assassinos mais temidos da cidade de Nova York, trabalhando em parceria com a máfia russa. Um dia, ele decide se aposentar, e neste período tem que lidar com a triste morte de sua esposa. Vítima de uma doença grave, ela já previa a sua própria morte, e deu de presente ao marido um cachorro para cuidar em seu período de luto. No entanto, poucos dias após o funeral, o cachorro é morto por ladrões que roubam o seu carro. John Wick parte em busca de vingança contra estes homens que ele já conhecia muito bem.");
        Foto foto2 = new Foto(R.drawable.jogovorazes, "Num futuro distante, boa parte da população é controlada por um regime totalitário, que relembra esse domínio realizando um evento anual - e mortal - entre os 12 distritos sob sua tutela. Para salvar sua irmã caçula, a jovem Katniss Everdeen (Jennifer Lawrence) se oferece como voluntária para representar seu distrito na competição e acaba contando com a companhia de Peeta Melark (Josh Hutcherson), desafiando não só o sistema dominante, mas também a força dos outros oponentes.");
        Foto foto3 = new Foto(R.drawable.matrix, "Em um futuro próximo, Thomas Anderson (Keanu Reeves), um jovem programador de computador que mora em um cubículo escuro, é atormentado por estranhos pesadelos nos quais encontra-se conectado por cabos e contra sua vontade, em um imenso sistema de computadores do futuro. Em todas essas ocasiões, acorda gritando no exato momento em que os eletrodos estão para penetrar em seu cérebro. À medida que o sonho se repete, Anderson começa a ter dúvidas sobre a realidade.");
        Foto foto4 = new Foto(R.drawable.fragmentado, "Kevin (James McAvoy) possui 23 personalidades distintas e consegue alterná-las quimicamente em seu organismo apenas com a força do pensamento. Um dia, ele sequestra três adolescentes que encontra em um estacionamento. Vivendo em cativeiro, elas passam a conhecer as diferentes facetas de Kevin e precisam encontrar algum meio de escapar.");
        Foto foto5 = new Foto(R.drawable.hp, "Harry Potter (Daniel Radcliffe) é um garoto órfão de 10 anos que vive infeliz com seus tios, os Dursley. Até que, repentinamente, ele recebe uma carta contendo um convite para ingressar em Hogwarts, uma famosa escola especializada em formar jovens bruxos. Inicialmente Harry é impedido de ler a carta por seu tio Válter (Richard Griffiths), mas logo ele recebe a visita de Hagrid (Robbie Coltrane), o guarda-caça de Hogwarts, que chega em sua casa para levá-lo até a escola.");

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
//        atual = (atual + 1) % fotos.size(); // 0 1 2

        if (atual == fotos.size() - 1) {
            atual = 0;
        } else {
            atual++;
        } // 0 1 2


        imageView.setImageResource(fotos.get(atual).getId());
        textView.setText(fotos.get(atual).getDescricao());
        recarregueLike();
    }

    public void volte(View view) {
//        atual = (atual < 0) ? 0 : atual - 1; // 2 1 0
        // atual = pergunta ? verdade : falsidade;
        if (atual == 0) {
            atual = fotos.size() - 1;
        } else {
            atual--;
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