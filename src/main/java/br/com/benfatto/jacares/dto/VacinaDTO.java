package br.com.benfatto.jacares.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor //Cria construtor vacio
@Getter(AccessLevel.PUBLIC) //Cria getter
@Setter(AccessLevel.PUBLIC) //Cria Setter
public class VacinaDTO {
    private Long id;
    private String nome;
    private String origem;
}
