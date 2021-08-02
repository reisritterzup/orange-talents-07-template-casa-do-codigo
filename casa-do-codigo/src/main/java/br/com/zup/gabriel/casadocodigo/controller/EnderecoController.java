package br.com.zup.gabriel.casadocodigo.controller;

import br.com.zup.gabriel.casadocodigo.dto.EnderecoDto;
import br.com.zup.gabriel.casadocodigo.dto.EnderecoRequestDto;
import br.com.zup.gabriel.casadocodigo.model.Endereco;
import br.com.zup.gabriel.casadocodigo.repository.EnderecoRepository;
import br.com.zup.gabriel.casadocodigo.repository.EstadoRepository;
import br.com.zup.gabriel.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    public ResponseEntity<EnderecoDto> cadastrarEndereco(@RequestBody @Valid EnderecoRequestDto requestDto){
        Endereco endereco = enderecoRepository.save(requestDto.toModel(paisRepository,estadoRepository));
        return ResponseEntity.ok(new EnderecoDto(endereco));
    }
}
