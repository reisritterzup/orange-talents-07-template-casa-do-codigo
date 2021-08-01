package br.com.zup.gabriel.casadocodigo.dto;

import br.com.zup.gabriel.casadocodigo.model.Livro;

public class DetalheLivro {

    public DetalheLivro() {
    }

    public DetalheLivro(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.categoriaNome = livro.getCategoria().getNome();
        this.autorNome = livro.getAutor().getNome();
        this.autorDescricao = livro.getAutor().getDescricao();
    }

    private String titulo;
    private String resumo;
    private String sumario;
    private double preco;
    private Integer numeroDePaginas;
    private String isbn;
    private String categoriaNome;
    private String autorNome;
    private String autorDescricao;

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public double getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public String getAutorNome() {
        return autorNome;
    }

    public String getAutorDescricao() {
        return autorDescricao;
    }
}
