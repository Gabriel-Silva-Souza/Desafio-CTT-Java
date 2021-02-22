package br.com.benfatto.jacares.controller;

import br.com.benfatto.jacares.dto.CreateRelatorioDTO;
import br.com.benfatto.jacares.dto.RelatorioDTO;
import br.com.benfatto.jacares.mapper.RelatoriosMapper;
import br.com.benfatto.jacares.service.MunicipioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/relatorios")
public class RelatoriosController {
    private final RelatoriosMapper relatoriosMapper;

    public RelatoriosController(RelatoriosMapper relatoriosMapper) {
        this.relatoriosMapper = relatoriosMapper;
    }

    @GetMapping()
    public ResponseEntity<RelatorioDTO> relatorioMunicipio(@RequestBody CreateRelatorioDTO dto){
        RelatorioDTO relatorioDTO = this.relatoriosMapper.relatorioMunicipio(dto.getData(), dto.getMunicipio());
        return new ResponseEntity<>(relatorioDTO, HttpStatus.FOUND);
    }
}
