package br.com.zup.gabriel.casadocodigo.dto;

import br.com.zup.gabriel.casadocodigo.model.Cliente;
import br.com.zup.gabriel.casadocodigo.model.Endereco;
import br.com.zup.gabriel.casadocodigo.repository.EnderecoRepository;
import br.com.zup.gabriel.casadocodigo.validacao.CpfOuCnpj;
import br.com.zup.gabriel.casadocodigo.validacao.ExistsId;
import br.com.zup.gabriel.casadocodigo.validacao.UniqueValue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ClienteRequestDto {

    public ClienteRequestDto() {
    }

    public ClienteRequestDto(String nome, String sobrenome, String email, String telefone, String documento, Long enderecoId) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.telefone = telefone;
        this.documento = documento;
        this.enderecoId = enderecoId;
    }

    @NotBlank
    @NotNull
    private String nome;

    @NotBlank
    @NotNull
    private String sobrenome;

    @NotBlank
    @Email
    @NotNull
    @UniqueValue(domainClass = Cliente.class,fieldName = "email")
    private String email;

    @NotBlank
    @NotNull
    private String telefone;

    @NotBlank
    @NotNull
    @CpfOuCnpj
    @UniqueValue(domainClass = Cliente.class,fieldName = "documento")
    private String documento;

    @NotNull
    @ExistsId(domainClass = Endereco.class,fieldName = "id")
    private Long enderecoId;

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

    public Long getEnderecoId() {
        return enderecoId;
    }

    public Cliente toModel(EnderecoRepository enderecoRepository){
        Optional<Endereco> optionalEndereco = enderecoRepository.findById(enderecoId);
        return new Cliente(nome,sobrenome,email,telefone,documento, optionalEndereco.get());
    }
}
