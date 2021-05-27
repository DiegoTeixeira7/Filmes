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

        Foto foto1 = new Foto(R.drawable.velo4, "Depois de ser visto rumo ao México no filme que deu origem a série, Dominic \"Dom\" Toretto (Vin Diesel) reaparece na República Dominicana praticando seus golpes ao lado de sua namorada Letty (Michelle Rodriguez) e sua gangue. Com o FBI na sua cola, Dom decide fugir para não comprometer seus comparsas. Contudo, um assassinato cometido por um traficante de drogas acende nele uma sede de vingança que o faz cruzar novamente com o agente Brian O'Conner (Paul Walker) numa perigosa missão.");
        Foto foto2 = new Foto(R.drawable.velo5, "Em Velozes & Furiosos 5 - Operação Rio, Dominic Toretto (Vin Diesel) foi resgatado da prisão por sua irmã Mia (Jordana Brewster) e Brian O'Conner (Paul Walker), que realizam um ousado resgate sobre rodas. Logo em seguida, ele desaparece. Brian e Mia vão até o Rio de Janeiro, onde encontram Vince (Matt Schulze). Ele propõe ao casal o roubo de carros que estão sendo levados em um trem, algo que, segundo ele, será uma operação simples que renderá um bom lucro.");
        Foto foto3 = new Foto(R.drawable.velo6, "Em Velozes e Furiosos 6, os heróis se espalham pelo mundo após o golpe de Dom (Vin Diesel) e Brian (Paul Walker) no Rio de Janeiro que deixou o grupo com US$100 milhões. Mas a incapacidade de voltar para casa e viver em um lar tornou suas vidas incompletas. Enquanto isso, Hobbs (Dwayne Johnson) esteve perseguindo uma organização de mercenários sobre rodas, um grupo de homens cruéis divididos em 12 países, cujo mentor (Luke Evans) tem ajuda da destemida Letty (Michelle Rodriguez), a antiga namorada de Dom, que ele acreditava estar morta.");
        Foto foto4 = new Foto(R.drawable.velo7, "Velozes e Furiosos 7 acompanha Dom (Vin Diesel), Brian (Paul Walker), Letty (Michelle Rodriguez) e o resto da equipe após os acontecimentos em Londres. Apesar de terem suas chances de voltar para os Estados Unidos e recomeçarem suas vidas, a tranquilidade do grupo é destruída quando Deckard Shaw (Jason Statham), um assassino profissional, quer vingança pela morte de seu irmão. Agora, a equipe tem que se reunir para impedir este novo vilão. Mas dessa vez, não é só sobre ser veloz.");
        Foto foto5 = new Foto(R.drawable.velo8, "Dom (Vin Diesel) e Letty (Michelle Rodriguez) estão curtindo a lua de mel em Havana, mas a súbita aparição de Cipher (Charlize Theron) atrapalha os planos do casal. Ela logo arma um plano para chantagear Dom, de forma que ele traia seus amigos e passe a ajudá-la a obter ogivas nucleares. Tal situação faz com Letty reúna os velhos amigos, que agora precisam enfrentar Cipher e, consequentemente, Dom.");

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