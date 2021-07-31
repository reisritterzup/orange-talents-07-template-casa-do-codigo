package br.com.zup.gabriel.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    public Categoria(){}

    public Categoria(String nome) {
        this.nome = nome;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true,nullable = false)
    private String nome;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
