package br.com.wa.waproject.models.entities;

import javax.persistence.*;

/**
 * @author: Harrisson Dutra
 */
@Entity
@Table(name = "exame")
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private tipoExame tipoExame;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Laboratorio laboratorio = new Laboratorio();

    public Exame() {
    }

    public Exame(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public br.com.wa.waproject.models.entities.tipoExame getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(br.com.wa.waproject.models.entities.tipoExame tipoExame) {
        this.tipoExame = tipoExame;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Laboratorio getLaboratorio() {
        laboratorio.setListaExames(null);
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }
}