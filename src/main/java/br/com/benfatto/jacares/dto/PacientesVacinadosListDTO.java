package br.com.benfatto.jacares.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class PacientesVacinadosListDTO {
    private List<PacientesVacinadosDTO> data;
    private Integer size;

    public PacientesVacinadosListDTO(List<PacientesVacinadosDTO> data){
        this.data = data;
        this.size = data.size();
    }

}
