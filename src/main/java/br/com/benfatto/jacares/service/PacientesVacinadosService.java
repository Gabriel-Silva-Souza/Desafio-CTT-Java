package br.com.benfatto.jacares.service;

import br.com.benfatto.jacares.model.Municipio;
import br.com.benfatto.jacares.model.PacientesVacinados;
import br.com.benfatto.jacares.model.Vacina;

import java.util.Date;

public interface PacientesVacinadosService extends BaseService<PacientesVacinados, Long> {
    PacientesVacinados findByMunicipioAndData(Municipio municipio, Date data);
    PacientesVacinados findByVacinaAndData(Vacina vacina, Date data);
}
