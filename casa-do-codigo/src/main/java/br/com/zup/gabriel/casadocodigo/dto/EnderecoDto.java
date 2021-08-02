package br.com.zup.gabriel.casadocodigo.dto;

import br.com.zup.gabriel.casadocodigo.model.Endereco;
import br.com.zup.gabriel.casadocodigo.model.Estado;
import br.com.zup.gabriel.casadocodigo.model.Pais;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

public class EnderecoDto {

    public EnderecoDto() {
    }

    public EnderecoDto(Endereco endereco) {
        this.cep = endereco.getCep();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();
        this.cidade = endereco.getCidade();
        this.paisNome = endereco.getPais().getNome();
        this.estadoNome = endereco.getEstado()!=null?
                endereco.getEstado().getNome():null;
    }

    public EnderecoDto(String cep, String rua, int numero, String complemento, String cidade, String paisNome, String estadoNome) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisNome = paisNome;
        this.estadoNome = estadoNome;
    }

    private String cep;

    private String rua;

    private int numero;

    private String complemento;

    private String cidade;

    private String paisNome;

    private String estadoNome;

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

    public String getPaisNome() {
        return paisNome;
    }

    public String getEstadoNome() {
        return estadoNome;
    }
}
