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
    private int atual;
    private TextView textView;
    private ImageButton imageButton;
    private TextView titulo;
    private Switch isHD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicialize();
    }

    private void inicialize() {
        imageView = findViewById(R.id.imagem);

        filmes = new ArrayList<>();

        Filme filme1 = new Filme(R.drawable.velo4, "Dominic Toretto descobre que sua amada Letty foi assassinada e resolve procurar pelo autor do crime. Enquanto isso, o agente Brian O'Conner está em busca de um traficante de drogas. Eles percebem que talvez procurem a mesma pessoa.", "Velozes e Furiosos 4");
        Filme filme2 = new Filme(R.drawable.velo5, "Desde que o ex-policial Brian O'Conner e Mia Toretto libertaram Dom da prisão, eles viajam pelo mundo para fugir das autoridades. No Rio de Janeiro, eles são obrigados a fazer um último trabalho antes de ganhar sua liberdade definitiva. Brian e Dom montam uma equipe de elite de pilotos de carro para executar a tarefa, mas precisam enfrentar um empresário corrupto.", "Velozes e Furiosos 5");
        Filme filme3 = new Filme(R.drawable.velo6, "Desde que o golpe de Dom e Brian no Rio de Janeiro deixou o grupo com 100 milhões de dólares, a equipe se espalhou pelo mundo. Um dia, Hobbs pede a Dom que reúna um grupo de elite em Londres e apreenda uma organização de mercenários nas ruas, cujo mentor é apoiado por Letty, a antiga namorada de Dom que ele acreditava estar morta.", "Velozes e Furiosos 6");
        Filme filme4 = new Filme(R.drawable.velo7, "Após os acontecimentos em Londres, Dom, Brian, Letty e o resto da equipe têm a chance de voltar para os Estados Unidos e recomeçar suas vidas. Mas a tranquilidade do grupo é destruída quando Deckard Shaw, um assassino profissional, quer vingança pelo acidente que deixou seu irmão em coma. Agora, a equipe tem de unir forças para deter um vilão novo e ainda mais perigoso.", "Velozes e Furiosos 7");
        Filme filme5 = new Filme(R.drawable.velo8, "Depois que Brian e Mia se aposentaram, e o resto da equipe foi exonerado, Dom e Letty estão em lua de mel e levam uma vida pacata e completamente normal. Mas a adrenalina do passado volta com tudo quando uma mulher misteriosa faz com que Dom retorne ao mundo do crime e da velocidade.", "Velozes e Furiosos 8");

        filmes.add(filme1);
        filmes.add(filme2);
        filmes.add(filme3);
        filmes.add(filme4);
        filmes.add(filme5);

        atual = 0;

        textView = findViewById(R.id.textoImagem);
        textView.setText(filmes.get(atual).getDescricao());

        titulo = findViewById(R.id.titulo);
        titulo.setText(filmes.get(atual).getTitulo());

        isHD = findViewById(R.id.isHD);
        imageButton = findViewById(R.id.btn_like);
    }

    public void avance(View view) {
        atual = (atual + 1) % filmes.size();
        imageView.setImageResource(filmes.get(atual).getId());
        textView.setText(filmes.get(atual).getDescricao());
        titulo.setText(filmes.get(atual).getTitulo());
        recarregueLike();
    }

    public void volte(View view) {
        atual = (atual == 0) ? filmes.size() - 1 : atual - 1;
        imageView.setImageResource(filmes.get(atual).getId());
        textView.setText(filmes.get(atual).getDescricao());
        titulo.setText(filmes.get(atual).getTitulo());
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
        it.putExtra("atual", atual);
        it.putExtra("isHD", isHD.isChecked());
        startActivity(it);
    }
}