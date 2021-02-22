package br.com.benfatto.jacares.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Entity
public class PacientesVacinados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "municipio")
    private Municipio municipio;

    @Column(name="data")
    private Date data;

    @Column(name = "vacinados")
    private Long vacinados;

    @ManyToOne
    @JoinColumn(name="vacina")
    private Vacina vacina;

}
