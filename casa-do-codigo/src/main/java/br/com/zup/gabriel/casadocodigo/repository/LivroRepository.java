package br.com.zup.gabriel.casadocodigo.repository;

import br.com.zup.gabriel.casadocodigo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro,Long> {
}
