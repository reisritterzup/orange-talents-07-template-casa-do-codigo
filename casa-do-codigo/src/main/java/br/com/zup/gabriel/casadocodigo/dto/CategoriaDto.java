package br.com.zup.gabriel.casadocodigo.dto;

import br.com.zup.gabriel.casadocodigo.model.Categoria;

public class CategoriaDto {

    public CategoriaDto(){};

    public CategoriaDto(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    private String nome;

    public String getNome() {
        return nome;
    }
}
