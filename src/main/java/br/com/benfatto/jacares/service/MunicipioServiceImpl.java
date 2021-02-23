package br.com.benfatto.jacares.service;

import br.com.benfatto.jacares.model.Estado;
import br.com.benfatto.jacares.model.Municipio;
import br.com.benfatto.jacares.repository.EstadoRepository;
import br.com.benfatto.jacares.repository.MunicipioRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MunicipioServiceImpl extends BaseServiceImpl<Municipio, Long> implements MunicipioService {
    private MunicipioRepository municipioRepository;
    private EstadoServiceImpl estadoService;

    public MunicipioServiceImpl(JpaRepository<Municipio, Long> repository, MunicipioRepository municipioRepository,
                                EstadoServiceImpl estadoService) {
        super(repository);
        this.municipioRepository = municipioRepository;
        this.estadoService = estadoService;
    }

    @Override
    public List<Municipio> findByEstado(String nome) {
        Estado estado = this.estadoService.findByUf(nome);
        return this.municipioRepository.findAllByEstadoEquals(estado);
    }

    @Override
    public Municipio findByNome(String nome) {
        return this.municipioRepository.findByNomeEquals(nome)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Municipio %s nao encontrado", nome)));
    }
}
