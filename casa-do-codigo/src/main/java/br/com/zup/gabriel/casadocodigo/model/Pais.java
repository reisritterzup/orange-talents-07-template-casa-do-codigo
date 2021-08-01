package br.com.zup.gabriel.casadocodigo.model;

import br.com.zup.gabriel.casadocodigo.validacao.UniqueValue;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Pais {

    public Pais() {
    }

    public Pais(String nome) {
        this.nome = nome;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false,unique = true)
    private String nome;

    @OneToMany
    private List<Estado> estadoList;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Estado> getEstadoList() {
        return estadoList;
    }
}
