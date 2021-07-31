package br.com.zup.gabriel.casadocodigo.dto;

import br.com.zup.gabriel.casadocodigo.model.Categoria;
import br.com.zup.gabriel.casadocodigo.validacao.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoriaRequestDto {

    public CategoriaRequestDto(){};

    public CategoriaRequestDto(String nome) {
        this.nome = nome;
    }

    @NotBlank
    @NotNull
    @UniqueValue(fieldName = "nome",domainClass = Categoria.class)
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel(){
        return new Categoria(this.nome);
    }
}
