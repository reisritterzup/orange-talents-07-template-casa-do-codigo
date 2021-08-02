package br.com.zup.gabriel.casadocodigo.repository;

import br.com.zup.gabriel.casadocodigo.controller.EnderecoController;
import br.com.zup.gabriel.casadocodigo.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
}
