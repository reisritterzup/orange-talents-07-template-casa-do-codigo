package br.com.zup.gabriel.casadocodigo.dto;

import br.com.zup.gabriel.casadocodigo.model.Estado;

public class EstadoDto {

    public EstadoDto() {
    }

    public EstadoDto(Estado estado) {
        this.nome = estado.getNome();
        this.paisNome = estado.getPais().getNome();
    }

    private String nome;

    private String paisNome;

    public String getNome() {
        return nome;
    }

    public String getPaisNome() {
        return paisNome;
    }
}
