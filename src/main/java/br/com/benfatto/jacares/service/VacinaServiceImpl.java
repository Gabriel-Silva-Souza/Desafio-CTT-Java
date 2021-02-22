package br.com.benfatto.jacares.service;

import br.com.benfatto.jacares.model.Vacina;
import br.com.benfatto.jacares.repository.VacinaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class VacinaServiceImpl extends BaseServiceImpl<Vacina, Long> implements VacinaService{
    private VacinaRepository vacinaRepository;

    public VacinaServiceImpl(JpaRepository<Vacina, Long> repository, VacinaRepository vacinaRepository) {
        super(repository);
        this.vacinaRepository = vacinaRepository;
    }


    @Override
    public Vacina findByNome(String nome) {
        return this.vacinaRepository.findByNome(nome)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Vacina %s nao encontrada", nome)));
    }
}
