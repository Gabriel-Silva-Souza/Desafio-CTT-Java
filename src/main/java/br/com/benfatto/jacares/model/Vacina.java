package br.com.benfatto.jacares.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Entity
public class Vacina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vacina_nome")
    private String nome;

    @Column(name="vacina_origem")
    private String origem;

    @OneToMany(mappedBy = "vacina")
    private List<PacientesVacinados> vacinados;

}
