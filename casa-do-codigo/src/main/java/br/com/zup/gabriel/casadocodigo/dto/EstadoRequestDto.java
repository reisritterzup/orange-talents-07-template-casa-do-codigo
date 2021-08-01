package br.com.zup.gabriel.casadocodigo.dto;

import br.com.zup.gabriel.casadocodigo.model.Estado;
import br.com.zup.gabriel.casadocodigo.model.Pais;
import br.com.zup.gabriel.casadocodigo.repository.PaisRepository;
import br.com.zup.gabriel.casadocodigo.validacao.ExistsId;
import br.com.zup.gabriel.casadocodigo.validacao.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequestDto {

    @NotBlank
    @NotNull
    @UniqueValue(domainClass = Estado.class,fieldName = "nome")
    private String nome;

    @ExistsId(fieldName = "id",domainClass = Pais.class)
    private Long paisId;

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Estado toModel(PaisRepository paisRepository){
        Pais pais = paisRepository.getById(paisId);
        return new Estado(nome,pais);
    }
}
