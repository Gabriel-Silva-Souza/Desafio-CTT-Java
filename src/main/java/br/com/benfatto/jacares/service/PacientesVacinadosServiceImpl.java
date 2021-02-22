package br.com.benfatto.jacares.service;

import br.com.benfatto.jacares.model.Municipio;
import br.com.benfatto.jacares.model.PacientesVacinados;
import br.com.benfatto.jacares.repository.PacienteVacinadoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@Service
public class PacientesVacinadosServiceImpl extends BaseServiceImpl<PacientesVacinados, Long>
        implements PacientesVacinadosService {
    private final PacienteVacinadoRepository pacienteVacinadoRepository;

    public PacientesVacinadosServiceImpl(JpaRepository<PacientesVacinados, Long> repository, PacienteVacinadoRepository pacienteVacinadoRepository) {
        super(repository);
        this.pacienteVacinadoRepository = pacienteVacinadoRepository;
    }


    @Override
    public PacientesVacinados findByMunicipioAndData(Municipio municipio, Date data) {
        return this.pacienteVacinadoRepository.findByMunicipioAndData(municipio, data)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Municipio %s com a data de vacinacao %s nao encontrado", municipio, data.toString())));
    }
}
