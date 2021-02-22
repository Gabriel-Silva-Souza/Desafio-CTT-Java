package br.com.benfatto.jacares.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class MunicipioListDTO {
    private List<MunicipioDTO> data;
    private Integer size;

    public MunicipioListDTO(List<MunicipioDTO> data){
        this.data = data;
        this.size = data.size();
    }
}
