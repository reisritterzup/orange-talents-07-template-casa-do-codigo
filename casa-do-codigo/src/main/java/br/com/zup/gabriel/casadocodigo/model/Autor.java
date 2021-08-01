package br.com.zup.gabriel.casadocodigo.model;

import br.com.zup.gabriel.casadocodigo.validacao.ExistsId;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Table(name = "Autor")
public class Autor {

    public Autor(){}

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    @Email(message = "Email inválido!")
    @Column(unique = true)
    private String email;

    @Length(max = 400)
    @Lob
    private String descricao;

    @NotNull
    private LocalDateTime dataCadastro = LocalDateTime.now();

    public Long getId(){return id;}

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }


}
