package br.com.zup.gabriel.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    public Cliente() {
    }

    public Cliente(String nome, String sobrenome, String email, String telefone, String documento, Endereco endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.telefone = telefone;
        this.documento = documento;
        this.endereco = endereco;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Column(nullable = false)
    private String sobrenome;

    @NotBlank
    @Email
    @Column(nullable = false,unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String telefone;

    @NotBlank
    @Column(nullable = false,unique = true)
    private String documento;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Endereco endereco;

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDocumento() {
        return documento;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
