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
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    //Many classe aonde eu estou
    //Muitos municipios tem um estado
    //Composicao de tabelas

    @ManyToOne
    @JoinColumn(name="estado")
    private Estado estado;

    @OneToMany(mappedBy = "municipio")
    private List<PacientesVacinados> vacinados;


}
