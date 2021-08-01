package br.com.zup.gabriel.casadocodigo.controller;

import br.com.zup.gabriel.casadocodigo.dto.EstadoDto;
import br.com.zup.gabriel.casadocodigo.dto.EstadoRequestDto;
import br.com.zup.gabriel.casadocodigo.model.Estado;
import br.com.zup.gabriel.casadocodigo.repository.EstadoRepository;
import br.com.zup.gabriel.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<EstadoDto> cadastrarEstado(@RequestBody @Valid EstadoRequestDto requestDto){
        Estado model = estadoRepository.save(requestDto.toModel(paisRepository));
        return ResponseEntity.ok(new EstadoDto(model));
    }
}
