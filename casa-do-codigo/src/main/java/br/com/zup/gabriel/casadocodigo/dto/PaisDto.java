package br.com.zup.gabriel.casadocodigo.dto;

import br.com.zup.gabriel.casadocodigo.model.Pais;

public class PaisDto {

    public PaisDto() {
    }

    public PaisDto(Pais pais) {
        this.nome = pais.getNome();
    }

    private String nome;

    public String getNome() {
        return nome;
    }
}
