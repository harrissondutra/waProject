package br.com.wa.waproject.models.entities;

import br.com.wa.waproject.models.repositories.ExameRepository;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Harrisson Dutra
 */
@Entity
@Table(name = "laboratorio")
public class Laboratorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String nome;
    private String endereco;

    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonIgnoreProperties("laboratorio")
    @OneToMany(mappedBy = "laboratorio")
    private List<Exame> listaExames = new ArrayList<Exame>();

    public Laboratorio() {
    }

    public Laboratorio(String nome) {
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Exame> getListaExames() {
        return listaExames;
    }

    public void setListaExames(List<Exame> listaExames) {
        this.listaExames = listaExames;
    }
}