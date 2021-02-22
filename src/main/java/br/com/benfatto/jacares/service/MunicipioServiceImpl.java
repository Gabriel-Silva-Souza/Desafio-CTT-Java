package br.com.benfatto.jacares.service;

import br.com.benfatto.jacares.model.Municipio;
import br.com.benfatto.jacares.repository.MunicipioRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class MunicipioServiceImpl extends BaseServiceImpl<Municipio, Long> implements MunicipioService {
    private MunicipioRepository municipioRepository;

    public MunicipioServiceImpl(MunicipioRepository repository) {
        super(repository);
        this.municipioRepository = repository;
    }


    @Override
    public Municipio findByNome(String nome) {
        return this.municipioRepository.findByNomeEquals(nome)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Municipio %s nao encontrado", nome)));
    }
}
