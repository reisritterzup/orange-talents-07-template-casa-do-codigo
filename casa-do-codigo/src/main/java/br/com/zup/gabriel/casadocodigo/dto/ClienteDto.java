package br.com.zup.gabriel.casadocodigo.dto;

import br.com.zup.gabriel.casadocodigo.model.Cliente;
import br.com.zup.gabriel.casadocodigo.model.Endereco;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ClienteDto {

    public ClienteDto() {
    }

    public ClienteDto(Cliente cliente) {
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.documento = cliente.getDocumento();
        this.endereco = cliente.getEndereco().toDto();
    }

    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private String documento;
    private EnderecoDto endereco;

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDocumento() {
        return documento;
    }

    public EnderecoDto getEndereco() {
        return endereco;
    }
}
