package br.com.benfatto.jacares.mapper;

import br.com.benfatto.jacares.dto.CreatePacientesVacinadosDTO;
import br.com.benfatto.jacares.dto.PacientesVacinadosDTO;
import br.com.benfatto.jacares.model.PacientesVacinados;
import br.com.benfatto.jacares.service.MunicipioService;
import br.com.benfatto.jacares.service.VacinaService;
import org.springframework.stereotype.Component;

@Component
public class PacientesVacinadosMapper {
    private final MunicipioService municipioService;
    private final VacinaService vacinaService;

    public PacientesVacinadosMapper(MunicipioService municipioService, VacinaService vacinaService) {
        this.municipioService = municipioService;
        this.vacinaService = vacinaService;
    }

    public PacientesVacinados mapToEntity(CreatePacientesVacinadosDTO dto){
        PacientesVacinados entity = new PacientesVacinados();
        entity.setData(dto.getData());
        entity.setVacinados(dto.getVacinados());
        if(dto.getVacina() != null){
            entity.setVacina(this.vacinaService.findByNome(dto.getVacina()));
        }
        if(dto.getMunicipio() != null){
            entity.setMunicipio(this.municipioService.findByNome(dto.getMunicipio()));
        }
        return entity;
    }

    public PacientesVacinados mapToEntity(PacientesVacinadosDTO dto){
        PacientesVacinados entity = new PacientesVacinados();
        entity.setData(dto.getData());
        entity.setVacinados(dto.getVacinados());
        if(dto.getVacina() != null){
            entity.setVacina(this.vacinaService.findByNome(dto.getVacina()));
        }
        if(dto.getMunicipio() != null){
            entity.setMunicipio(this.municipioService.findByNome(dto.getMunicipio()));
        }
        return entity;
    }

    public PacientesVacinadosDTO mapToDTO(PacientesVacinados entity){
        PacientesVacinadosDTO dto = new PacientesVacinadosDTO();
        dto.setId(entity.getId());
        dto.setVacinados(entity.getVacinados());
        dto.setData(entity.getData());
        if(entity.getVacina() != null){
            dto.setVacina(entity.getVacina().getNome());
        }
        if(entity.getMunicipio() != null){
            dto.setMunicipio(entity.getMunicipio().getNome());
        }
        return dto;
    }
}
