package br.com.benfatto.jacares.service;

import br.com.benfatto.jacares.model.Vacina;

public interface VacinaService extends BaseService<Vacina, Long>{
    Vacina findByNome(String nome);
}
