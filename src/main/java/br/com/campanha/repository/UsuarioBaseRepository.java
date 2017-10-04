package br.com.campanha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.campanha.domain.Usuario;

@Repository
public interface UsuarioBaseRepository extends JpaRepository<Usuario, Long> {

}
