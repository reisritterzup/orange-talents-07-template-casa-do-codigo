package br.com.zup.gabriel.casadocodigo.dto;

import br.com.zup.gabriel.casadocodigo.model.Autor;
import br.com.zup.gabriel.casadocodigo.model.Categoria;
import br.com.zup.gabriel.casadocodigo.model.Livro;
import br.com.zup.gabriel.casadocodigo.repository.AutorRepository;
import br.com.zup.gabriel.casadocodigo.repository.CategoriaRepository;
import br.com.zup.gabriel.casadocodigo.validacao.UniqueValue;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Optional;

public class LivroRequestDto {

    public LivroRequestDto() {
    }

    public LivroRequestDto(String titulo, String resumo, String sumario, double preco, Integer numeroDePaginas, String isbn, LocalDateTime publicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.publicacao = publicacao;
        this.categoriaId = categoria.getId();
        this.autorId = autor.getId();
    }

    @NotBlank
    @NotNull
    @UniqueValue(domainClass = Livro.class , fieldName = "titulo")
    private String titulo;

    @Lob
    @Length(max = 500)
    @NotNull
    private String resumo;

    private String sumario;

    @Min(20)
    @NotNull
    private double preco;

    @Min(100)
    @NotNull
    private Integer numeroDePaginas;

    @NotBlank
    @NotNull
    @UniqueValue(fieldName = "isbn",domainClass = Livro.class)
    private String isbn;

    @Future
    private LocalDateTime publicacao;

    @NotNull
    private Long categoriaId;

    @NotNull
    private Long autorId;

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

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public Livro toModel(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        Optional<Autor> autor = autorRepository.findById(autorId);
        Optional<Categoria> categoria = categoriaRepository.findById(categoriaId);
        return new Livro(titulo,resumo,sumario,preco,numeroDePaginas,isbn,publicacao,categoria.get(),autor.get());
    }
}
