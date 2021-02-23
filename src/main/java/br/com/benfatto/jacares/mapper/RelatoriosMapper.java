package br.com.benfatto.jacares.mapper;

import br.com.benfatto.jacares.dto.*;
import br.com.benfatto.jacares.model.Municipio;
import br.com.benfatto.jacares.model.PacientesVacinados;
import br.com.benfatto.jacares.model.Vacina;
import br.com.benfatto.jacares.service.MunicipioService;
import br.com.benfatto.jacares.service.PacientesVacinadosService;
import br.com.benfatto.jacares.service.VacinaService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RelatoriosMapper {
    private final PacientesVacinadosService pacientesVacinadosService;
    private final MunicipioService municipioService;
    private final VacinaService vacinaService;

    public RelatoriosMapper(PacientesVacinadosService pacientesVacinadosService, MunicipioService municipioService, VacinaService vacinaService) {
        this.pacientesVacinadosService = pacientesVacinadosService;
        this.municipioService = municipioService;
        this.vacinaService = vacinaService;
    }

    public RelatorioMunicipioDTO relatorioMunicipio(CreateRelatorioMunicipioDTO dto){
        Municipio municipio = this.municipioService.findByNome(dto.getMunicipio());
        PacientesVacinados found = this.pacientesVacinadosService.findByMunicipioAndData(municipio,dto.getData());
        RelatorioMunicipioDTO relatorio = new RelatorioMunicipioDTO();
        relatorio.setMunicipio(dto.getMunicipio());
        relatorio.setTotalVacinados(found.getVacinados());
        return relatorio;
    }

    public RelatorioVacinaDTO relatorioVacinaDTO(CreateRelatorioVacinaDTO dto){
        Vacina vacina = this.vacinaService.findByNome(dto.getVacina());
        PacientesVacinados found= this.pacientesVacinadosService.findByVacinaAndData(vacina, dto.getData());
        RelatorioVacinaDTO relatorio = new RelatorioVacinaDTO();
        relatorio.setVacina(dto.getVacina());
        relatorio.setTotalVacinado(found.getVacinados());
        return relatorio;
    }

    public RelatorioEstadoDTO relatorioEstado(CreateRelatorioEstadoDTO dto){
        RelatorioEstadoDTO relatorioEstadoDTO = new RelatorioEstadoDTO();
        Integer quantidadeVacinados = 0;
        List<Municipio> municipios = this.municipioService.findByEstado(dto.getEstado());
        for(Municipio municipio : municipios) {
            System.out.println(municipio.getNome());
            PacientesVacinados found = this.pacientesVacinadosService.findByMunicipioAndData(municipio, dto.getData());
            System.out.println(found.getVacinados());
            quantidadeVacinados += Math.toIntExact(found.getVacinados());
        }
        relatorioEstadoDTO.setEstado(dto.getEstado());
        relatorioEstadoDTO.setTotalVacinados(quantidadeVacinados);
        return relatorioEstadoDTO;
    }


}
