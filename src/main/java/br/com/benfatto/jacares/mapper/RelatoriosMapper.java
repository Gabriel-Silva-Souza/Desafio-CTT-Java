package br.com.benfatto.jacares.mapper;

import br.com.benfatto.jacares.dto.*;
import br.com.benfatto.jacares.model.Municipio;
import br.com.benfatto.jacares.model.PacientesVacinados;
import br.com.benfatto.jacares.model.Vacina;
import br.com.benfatto.jacares.service.MunicipioService;
import br.com.benfatto.jacares.service.PacientesVacinadosService;
import br.com.benfatto.jacares.service.VacinaService;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
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
        Integer quantidadeVacinados = 0;
        List<PacientesVacinados> found= this.pacientesVacinadosService.findByVacinaAndData(vacina, dto.getData());
        for(PacientesVacinados pacientesVacinados : found){
            quantidadeVacinados += Math.toIntExact(pacientesVacinados.getVacinados());
        }
        RelatorioVacinaDTO relatorio = new RelatorioVacinaDTO();
        relatorio.setVacina(dto.getVacina());
        relatorio.setTotalVacinado(quantidadeVacinados);
        relatorio.setRegistrosDeUso(found.size());
        return relatorio;
    }

    public  ListRelatorioVacinaDTO relatorioVacinasDTO(Date periodo){
        List<Vacina> vacinas = this.vacinaService.findAll();
        System.out.println(vacinas.size());
        ArrayList<RelatorioVacinaDTO> listaRelatorio = new ArrayList<>();
        for(Vacina vacina : vacinas){
            CreateRelatorioVacinaDTO relatorioVacinaDTO = new CreateRelatorioVacinaDTO();
            System.out.println(vacina.getNome());
            relatorioVacinaDTO.setVacina(vacina.getNome());
            relatorioVacinaDTO.setData(periodo);
            RelatorioVacinaDTO relatorio = this.relatorioVacinaDTO(relatorioVacinaDTO);
            System.out.println(relatorio.getVacina());
            listaRelatorio.add(relatorio);
        }
        System.out.println(listaRelatorio.get(0));
        ListRelatorioVacinaDTO relatorio = new ListRelatorioVacinaDTO(listaRelatorio);
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
