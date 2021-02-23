package br.com.benfatto.jacares.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class ListRelatorioVacinaDTO {
    private List<RelatorioVacinaDTO> data;
    private Integer registros;

    public ListRelatorioVacinaDTO(List<RelatorioVacinaDTO> data) {
        this.data = data;
        this.registros = data.size();
    }
}
