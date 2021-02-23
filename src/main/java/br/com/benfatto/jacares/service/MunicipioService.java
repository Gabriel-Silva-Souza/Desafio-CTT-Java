package br.com.benfatto.jacares.service;

import br.com.benfatto.jacares.model.Estado;
import br.com.benfatto.jacares.model.Municipio;

import java.util.List;

public interface MunicipioService extends BaseService<Municipio, Long> {
    List<Municipio> findByEstado(String nome);
    Municipio findByNome(String nome);
}
