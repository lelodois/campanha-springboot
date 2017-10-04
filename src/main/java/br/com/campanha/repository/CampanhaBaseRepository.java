package br.com.campanha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.campanha.domain.Campanha;

@Repository
public interface CampanhaBaseRepository extends JpaRepository<Campanha, Long> {

}
