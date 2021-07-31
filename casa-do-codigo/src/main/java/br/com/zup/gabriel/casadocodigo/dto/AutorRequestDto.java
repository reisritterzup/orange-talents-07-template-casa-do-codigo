package br.com.zup.gabriel.casadocodigo.dto;

import br.com.zup.gabriel.casadocodigo.model.Autor;
import br.com.zup.gabriel.casadocodigo.validacao.ExistsId;
import br.com.zup.gabriel.casadocodigo.validacao.UniqueValue;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AutorRequestDto {

    public AutorRequestDto(){}

    public AutorRequestDto(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    @Email(message = "Email inválido!")
    @UniqueValue(domainClass = Autor.class,fieldName = "email")
    private String email;

    @Length(max = 400)
    @Lob
    private String descricao;

    public Autor toModel(){
        return new Autor(this.nome,this.email,this.descricao);
    }

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
