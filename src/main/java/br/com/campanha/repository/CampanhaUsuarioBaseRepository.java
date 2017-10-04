package br.com.campanha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.campanha.domain.CampanhaUsuario;

@Repository
public interface CampanhaUsuarioBaseRepository extends JpaRepository<CampanhaUsuario, Long> {

}
