package br.com.benfatto.jacares.service;

import br.com.benfatto.jacares.model.Estado;
import br.com.benfatto.jacares.repository.EstadoRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class EstadoServiceImpl  extends BaseServiceImpl<Estado, Long> implements EstadoService{
    private EstadoRepository estadoRepository;

    public EstadoServiceImpl(EstadoRepository repository){
        super(repository);
        this.estadoRepository = repository;
    }


    @Override
    public Estado findByUf(String uf) {
        return this.estadoRepository.findBySiglaEquals(uf)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Estado com UF %s nao encontrado", uf)));
    }
}
