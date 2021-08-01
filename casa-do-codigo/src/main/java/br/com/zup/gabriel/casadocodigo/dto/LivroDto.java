package br.com.zup.gabriel.casadocodigo.dto;

import br.com.zup.gabriel.casadocodigo.model.Livro;

import java.time.LocalDateTime;

public class LivroDto {

    public LivroDto() {
    }

    public LivroDto(Livro livro){
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.publicacao = livro.getPublicacao();
        this.categoriaNome = livro.getCategoria().getNome();
        this.autorNome = livro.getAutor().getNome();
    }

    private String titulo;
    private String resumo;
    private String sumario;
    private double preco;
    private Integer numeroDePaginas;
    private String isbn;
    private LocalDateTime publicacao;
    private String categoriaNome;
    private String autorNome;

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

    public LocalDateTime getPublicacao() {
        return publicacao;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public String getAutorNome() {
        return autorNome;
    }
}
