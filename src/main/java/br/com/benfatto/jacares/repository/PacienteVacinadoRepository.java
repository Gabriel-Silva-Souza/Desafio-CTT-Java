package br.com.benfatto.jacares.repository;

import br.com.benfatto.jacares.model.Municipio;
import br.com.benfatto.jacares.model.PacientesVacinados;
import br.com.benfatto.jacares.model.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface PacienteVacinadoRepository extends JpaRepository<PacientesVacinados, Long> {
    Optional<PacientesVacinados> findByMunicipioAndData(Municipio municipio, Date data);
    Optional<PacientesVacinados> findByVacinaAndData(Vacina vacina, Date data);
}
