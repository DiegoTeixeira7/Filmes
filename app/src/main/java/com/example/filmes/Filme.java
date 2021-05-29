package com.example.filmes;

public class Filme {

    private int id;
    private int idVideo;
    private int idVideoHd;
    private String descricao;
    private String titulo;
    private boolean like;

    public Filme(int id, String descricao, String titulo) {
        this.id = id;
        this.descricao = descricao;
        this.titulo = titulo;
        like = false;
    }

    public int getId() { return id; }

    public String getDescricao() { return descricao; }

    public String getTitulo() { return titulo; }

    public boolean isLike() { return like; }

    public void setLike(boolean like) { this.like = like; }
}
