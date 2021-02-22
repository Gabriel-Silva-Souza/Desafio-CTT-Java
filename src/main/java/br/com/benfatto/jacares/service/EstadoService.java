package br.com.benfatto.jacares.service;

import br.com.benfatto.jacares.model.Estado;

public interface EstadoService extends BaseService<Estado, Long>{

    Estado findByUf(String uf);

}
