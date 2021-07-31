package br.com.zup.gabriel.casadocodigo.repository;

import br.com.zup.gabriel.casadocodigo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
