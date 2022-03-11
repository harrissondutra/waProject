package br.com.wa.waproject.models.entities;

public enum tipoExame {

    Clinico(1, "Clínico"),
    Imagem(2, "Imagem");

    private final int id;
    private final String descricao;

    tipoExame(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "tipoExame{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
