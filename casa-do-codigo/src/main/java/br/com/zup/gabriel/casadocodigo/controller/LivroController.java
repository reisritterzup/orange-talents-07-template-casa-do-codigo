package br.com.zup.gabriel.casadocodigo.controller;

import br.com.zup.gabriel.casadocodigo.dto.LivroDto;
import br.com.zup.gabriel.casadocodigo.dto.LivroRequestDto;
import br.com.zup.gabriel.casadocodigo.model.Livro;
import br.com.zup.gabriel.casadocodigo.repository.AutorRepository;
import br.com.zup.gabriel.casadocodigo.repository.CategoriaRepository;
import br.com.zup.gabriel.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("livro/")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<LivroDto> cadastrarLivro(@RequestBody @Valid LivroRequestDto requestDto){
        Livro model = livroRepository.save(requestDto.toModel(autorRepository,categoriaRepository));
        return ResponseEntity.ok(new LivroDto(model));
    }
}
