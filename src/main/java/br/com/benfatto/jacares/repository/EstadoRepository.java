package br.com.benfatto.jacares.repository;

import br.com.benfatto.jacares.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    //select * from estado where sigla = '<sigla>'
    Optional<Estado> findBySiglaEquals(String sigla);

    //Requisicao complexa
    Estado findAllByIdBeforeAndNomeContaining(Long id, String nome);

}
