package br.com.benfatto.jacares.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class RelatorioMunicipioDTO {
    private String municipio;
    private Long totalVacinados;
}
