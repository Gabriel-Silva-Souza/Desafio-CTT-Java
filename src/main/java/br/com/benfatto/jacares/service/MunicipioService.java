package br.com.benfatto.jacares.service;

import br.com.benfatto.jacares.model.Municipio;

public interface MunicipioService extends BaseService<Municipio, Long> {

    Municipio findByNome(String nome);
}
