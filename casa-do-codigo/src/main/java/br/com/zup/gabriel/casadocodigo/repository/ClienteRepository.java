package br.com.zup.gabriel.casadocodigo.repository;

import br.com.zup.gabriel.casadocodigo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
