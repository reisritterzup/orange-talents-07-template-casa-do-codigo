package br.com.zup.gabriel.casadocodigo.controller;

import br.com.zup.gabriel.casadocodigo.model.Autor;
import br.com.zup.gabriel.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping(value = "")
    public ResponseEntity<Autor> cadastrarAutor(@Valid @RequestBody Autor autor){

            Autor response = autorRepository.save(autor);
            return ResponseEntity.ok(response);

    }
}
