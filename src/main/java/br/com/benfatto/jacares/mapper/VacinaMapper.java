package br.com.benfatto.jacares.mapper;

import br.com.benfatto.jacares.dto.VacinaDTO;
import br.com.benfatto.jacares.model.Vacina;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VacinaMapper {
    private final ModelMapper modelMapper;

    public VacinaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VacinaDTO mapToDTO(Vacina entity){
        return this.modelMapper.map(entity, VacinaDTO.class);
    }

    public Vacina mapToEntity(VacinaDTO dto){
        return this.modelMapper.map(dto, Vacina.class );//Primeiro objeto para mapear e depois para onde mapearemos
    }
}
