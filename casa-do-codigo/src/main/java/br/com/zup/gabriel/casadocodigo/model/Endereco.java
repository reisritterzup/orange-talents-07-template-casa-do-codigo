package br.com.zup.gabriel.casadocodigo.model;

import br.com.zup.gabriel.casadocodigo.dto.EnderecoDto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Endereco {

    public Endereco() {
    }

    public Endereco(String cep, String rua, int numero, String complemento, String cidade, Pais pais, Estado estado) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String cep;

    @NotBlank
    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private int numero;

    @NotBlank
    @Column(nullable = false)
    private String complemento;

    @NotBlank
    @Column(nullable = false)
    private String cidade;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Pais pais;

    @ManyToOne
    private Estado estado;

    public Long getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public EnderecoDto toDto(){
        return new EnderecoDto(cep,rua,numero,complemento,cidade, pais.getNome(), estado.getNome());
    }
}
