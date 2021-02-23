package br.com.benfatto.jacares.controller;

import br.com.benfatto.jacares.dto.*;
import br.com.benfatto.jacares.mapper.RelatoriosMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/relatorios")
public class RelatoriosController {
    private final RelatoriosMapper relatoriosMapper;

    public RelatoriosController(RelatoriosMapper relatoriosMapper) {
        this.relatoriosMapper = relatoriosMapper;
    }

    @GetMapping("/municipio")
    public ResponseEntity<RelatorioMunicipioDTO> relatorioMunicipio(@RequestBody CreateRelatorioMunicipioDTO dto){
        RelatorioMunicipioDTO relatorioMunicipioDTO = this.relatoriosMapper.relatorioMunicipio(dto);
        return new ResponseEntity<>(relatorioMunicipioDTO, HttpStatus.FOUND);
    }
    @GetMapping("/estado")
    public ResponseEntity<RelatorioEstadoDTO> relatorioEstado(@RequestBody CreateRelatorioEstadoDTO dto){
        RelatorioEstadoDTO relatorioEstadoDTO = this.relatoriosMapper.relatorioEstado(dto);
        return new ResponseEntity<>(relatorioEstadoDTO, HttpStatus.FOUND);
    }
    @GetMapping("/vacina")
    public ResponseEntity<RelatorioVacinaDTO> relatorioVacina(@RequestBody CreateRelatorioVacinaDTO dto){
        RelatorioVacinaDTO relatorioVacinaDTO = this.relatoriosMapper.relatorioVacinaDTO(dto);
        return new ResponseEntity<>(relatorioVacinaDTO, HttpStatus.FOUND);
    }
    @GetMapping("/vacinas")
    public ResponseEntity<ListRelatorioVacinaDTO> relatorioVacinas(@RequestBody DateDTO periodo){
        ListRelatorioVacinaDTO relatoriosVacinaDTO = this.relatoriosMapper.relatorioVacinasDTO(periodo.getData());
        return new ResponseEntity<>(relatoriosVacinaDTO, HttpStatus.FOUND);
    }

}
