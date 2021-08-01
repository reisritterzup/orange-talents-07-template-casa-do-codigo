package br.com.zup.gabriel.casadocodigo.model;


import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Livro {

    public Livro() {
    }

    public Livro(String titulo, String resumo, String sumario, double preco, Integer numeroDePaginas, String isbn, LocalDateTime publicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.publicacao = publicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false,unique = true)
    private String titulo;

    @Lob
    @Length(max = 500)
    @Column(nullable = false)
    private String resumo;

    private String sumario;

    @Min(20)
    @Column(nullable = false)
    private double preco;

    @Min(100)
    @Column(nullable = false)
    private Integer numeroDePaginas;

    @NotBlank
    @Column(nullable = false,unique = true)
    private String isbn;

    @Future
    private LocalDateTime publicacao;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Autor autor;

    public Long getId(){return id;}

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

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
