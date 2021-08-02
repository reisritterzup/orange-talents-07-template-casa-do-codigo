package br.com.zup.gabriel.casadocodigo.dto;

import br.com.zup.gabriel.casadocodigo.model.Endereco;
import br.com.zup.gabriel.casadocodigo.model.Estado;
import br.com.zup.gabriel.casadocodigo.model.Pais;
import br.com.zup.gabriel.casadocodigo.repository.EstadoRepository;
import br.com.zup.gabriel.casadocodigo.repository.PaisRepository;
import br.com.zup.gabriel.casadocodigo.validacao.ExistsId;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class EnderecoRequestDto {

    public EnderecoRequestDto() {
    }

    public EnderecoRequestDto(String cep, String rua, int numero, String complemento, String cidade, Long paisId, Long estadoId) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
    }

    @NotBlank
    @NotNull
    private String cep;

    @NotBlank
    @NotNull
    private String rua;

    @NotNull
    private int numero;

    @NotBlank
    @NotNull
    private String complemento;

    @NotBlank
    @NotNull
    private String cidade;

    @NotNull
    @ExistsId(fieldName = "id",domainClass = Pais.class)
    private Long paisId;

    @ExistsId(fieldName = "id",domainClass = Estado.class)
    private Long estadoId;

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

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public Endereco toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        Optional<Pais> optionalPais = paisRepository.findById(paisId);
        Optional<Estado> optionalEstado;
        Estado response = null;
        if(optionalPais.isPresent() && !optionalPais.get().getEstadoList().isEmpty())
            for(Estado estado:optionalPais.get().getEstadoList())
                if(estadoId.equals(estado.getId())){
                    optionalEstado = estadoRepository.findById(estadoId);
                    response = optionalEstado.get();
                    break;
                }

        return new Endereco(cep,rua,numero,complemento,cidade,optionalPais.get(),response);
    }
}
