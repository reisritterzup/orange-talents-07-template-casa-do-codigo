package br.com.zup.gabriel.casadocodigo.dto;

import br.com.zup.gabriel.casadocodigo.model.Pais;
import br.com.zup.gabriel.casadocodigo.validacao.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PaisRequestDto {

    public PaisRequestDto() {
    }

    public PaisRequestDto(String nome) {
        this.nome = nome;
    }

    @NotNull
    @NotBlank
    @UniqueValue(domainClass = Pais.class,fieldName = "nome")
    private String nome;

    public String getNome(){return this.nome;}

    public Pais toModel(){
        return new Pais(nome);
    }
}
