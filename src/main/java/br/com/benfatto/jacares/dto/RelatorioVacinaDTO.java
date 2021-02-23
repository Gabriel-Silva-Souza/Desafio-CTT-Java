package br.com.benfatto.jacares.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class RelatorioVacinaDTO {
    public String vacina;
    @JsonProperty("total de vacinados")
    public Integer totalVacinado;
    @JsonProperty("registro de uso")
    public Integer registrosDeUso;
}
