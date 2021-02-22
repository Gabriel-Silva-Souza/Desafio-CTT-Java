package br.com.benfatto.jacares.repository;

import br.com.benfatto.jacares.model.PacientesVacinados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteVacinadoRepository extends JpaRepository<PacientesVacinados, Long> {
}
