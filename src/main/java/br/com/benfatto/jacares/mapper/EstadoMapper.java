package br.com.benfatto.jacares.mapper;

import br.com.benfatto.jacares.dto.EstadoDTO;
import br.com.benfatto.jacares.model.Estado;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EstadoMapper {
    private final ModelMapper modelMapper;

    public EstadoMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public EstadoDTO convertToDTO(Estado entity){
        return this.modelMapper
                .typeMap(Estado.class, EstadoDTO.class) //Setando as classes que ele vai trabalhar
                .addMapping(Estado::getSigla, EstadoDTO::setUf)
                .map(entity);
    }

    public Estado convertToEntity(EstadoDTO dto){
        return this.modelMapper
                .typeMap(EstadoDTO.class, Estado.class) //Setando as classes a base e a que vai ser criada
                .addMapping(EstadoDTO::getUf, Estado::setSigla) //de onde ele e aonde ele seta
                .map(dto); //define a variavel de mapeamento
    }
}
