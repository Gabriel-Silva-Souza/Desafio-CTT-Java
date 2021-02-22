package br.com.benfatto.jacares.service;

import br.com.benfatto.jacares.model.PacientesVacinados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PacientesVacinadosServiceImpl extends BaseServiceImpl<PacientesVacinados, Long>
        implements PacientesVacinadosService {
    public PacientesVacinadosServiceImpl(JpaRepository<PacientesVacinados, Long> repository) {
        super(repository);
    }
}
