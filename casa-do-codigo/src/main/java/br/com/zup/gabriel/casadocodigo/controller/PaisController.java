package br.com.zup.gabriel.casadocodigo.controller;

import br.com.zup.gabriel.casadocodigo.dto.PaisDto;
import br.com.zup.gabriel.casadocodigo.dto.PaisRequestDto;
import br.com.zup.gabriel.casadocodigo.model.Pais;
import br.com.zup.gabriel.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<PaisDto> cadastrarPais(@RequestBody @Valid PaisRequestDto requestDto){
        Pais model = paisRepository.save(requestDto.toModel());
        return ResponseEntity.ok(new PaisDto(model));
    }
}
