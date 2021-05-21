package com.example.filmes;

public class Foto {

    private int id;
    private String descricao;
    private boolean like;

    public Foto(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        like = false;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
