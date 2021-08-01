package br.com.zup.gabriel.casadocodigo.controller;

import br.com.zup.gabriel.casadocodigo.dto.DetalheLivro;
import br.com.zup.gabriel.casadocodigo.model.Livro;
import br.com.zup.gabriel.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("detalhe/")
public class DetalheLivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping("{id}")
    public ResponseEntity<DetalheLivro> buscarDetalheLivroPeloId(@PathVariable Long id){
        Optional<Livro> livro = livroRepository.findById(id);
        return livro.isPresent()?
                ResponseEntity.ok(new DetalheLivro(livro.get())):
                ResponseEntity.notFound().build();
    }
}
