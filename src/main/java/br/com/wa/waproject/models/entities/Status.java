package br.com.wa.waproject.models.entities;


public enum Status {
    Ativo(1, "Ativo"),
    Inativo(0, "Inativo");


   private final int id;
   private final String descricao;

    Status(int id, String descricao) {
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
        return "Status{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
