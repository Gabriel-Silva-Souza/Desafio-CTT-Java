package br.com.benfatto.jacares.mapper;

import br.com.benfatto.jacares.dto.CreateMunicipioDTO;
import br.com.benfatto.jacares.dto.MunicipioDTO;
import br.com.benfatto.jacares.model.Municipio;
import br.com.benfatto.jacares.service.EstadoService;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class MunicipioMapper {
    private final EstadoService estadoService;

    public MunicipioMapper(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    public Municipio mapToEntity(CreateMunicipioDTO dto){
        Municipio municipio = new Municipio();
        if(dto.getUf() != null){
            municipio.setEstado(this.estadoService.findByUf(dto.getUf()));
        }
        municipio.setNome(dto.getNome());
        return municipio;
    }

    public MunicipioDTO mapToDTO(Municipio entity){
        MunicipioDTO dto = new MunicipioDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        if(entity.getEstado() != null){
            dto.setUf(entity.getEstado().getSigla());
        }
        return dto;
    }
}
