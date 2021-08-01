package br.com.zup.gabriel.casadocodigo.dto;

import br.com.zup.gabriel.casadocodigo.model.Livro;

public class ItemListaLivro {

    public ItemListaLivro() {
    }

    public ItemListaLivro(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    private Long id;
    private String titulo;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
