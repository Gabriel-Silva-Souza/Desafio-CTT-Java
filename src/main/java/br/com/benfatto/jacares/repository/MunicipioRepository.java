package br.com.benfatto.jacares.repository;

import br.com.benfatto.jacares.model.Estado;
import br.com.benfatto.jacares.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
    Optional<Municipio> findByNomeEquals(String nome);
    List<Municipio> findAllByEstadoEquals(Estado estado);
}
