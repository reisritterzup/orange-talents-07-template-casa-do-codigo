package br.com.zup.gabriel.casadocodigo.controller;

import br.com.zup.gabriel.casadocodigo.dto.AutorDto;
import br.com.zup.gabriel.casadocodigo.dto.AutorRequestDto;
import br.com.zup.gabriel.casadocodigo.model.Autor;
import br.com.zup.gabriel.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("autor/")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<AutorDto> cadastrarAutor(@Valid @RequestBody AutorRequestDto autor){
        Autor response = autorRepository.save(autor.toModel());
        return ResponseEntity.ok(new AutorDto(response));
    }
}
