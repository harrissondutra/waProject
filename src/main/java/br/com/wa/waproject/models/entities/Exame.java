package br.com.wa.waproject.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @JsonIgnoreProperties("listaExames")
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

        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }
}