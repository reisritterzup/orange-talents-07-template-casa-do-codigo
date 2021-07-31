package br.com.zup.gabriel.casadocodigo.controller;

import br.com.zup.gabriel.casadocodigo.dto.CategoriaDto;
import br.com.zup.gabriel.casadocodigo.dto.CategoriaRequestDto;
import br.com.zup.gabriel.casadocodigo.model.Categoria;
import br.com.zup.gabriel.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("categoria/")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<CategoriaDto> cadastrarCategoria(@RequestBody @Valid CategoriaRequestDto requestDto){
        Categoria model = categoriaRepository.save(requestDto.toModel());
        return ResponseEntity.ok(new CategoriaDto(model));
    }
}
