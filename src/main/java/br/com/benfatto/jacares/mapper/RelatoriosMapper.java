package br.com.benfatto.jacares.mapper;

import br.com.benfatto.jacares.dto.RelatorioDTO;
import br.com.benfatto.jacares.model.Municipio;
import br.com.benfatto.jacares.model.PacientesVacinados;
import br.com.benfatto.jacares.service.EstadoService;
import br.com.benfatto.jacares.service.MunicipioService;
import br.com.benfatto.jacares.service.PacientesVacinadosService;
import br.com.benfatto.jacares.service.VacinaService;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class RelatoriosMapper {
    private final PacientesVacinadosService pacientesVacinadosService;
    private final MunicipioService municipioService;

    public RelatoriosMapper(PacientesVacinadosService pacientesVacinadosService, MunicipioService municipioService) {
        this.pacientesVacinadosService = pacientesVacinadosService;
        this.municipioService = municipioService;
    }

    public RelatorioDTO relatorioMunicipio(Date periodo, String nome){
        Municipio municipio = this.municipioService.findByNome(nome);
        PacientesVacinados found = this.pacientesVacinadosService.findByMunicipioAndData(municipio,periodo);
        RelatorioDTO relatorio = new RelatorioDTO();
        relatorio.setTipo(nome);
        relatorio.setTotalVacinados(found.getVacinados());
        return relatorio;
    }


}
