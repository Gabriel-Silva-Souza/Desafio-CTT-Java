package br.com.benfatto.jacares.controller;

import br.com.benfatto.jacares.dto.CreatePacientesVacinadosDTO;
import br.com.benfatto.jacares.dto.PacientesVacinadosDTO;
import br.com.benfatto.jacares.dto.PacientesVacinadosListDTO;
import br.com.benfatto.jacares.mapper.PacientesVacinadosMapper;
import br.com.benfatto.jacares.model.PacientesVacinados;
import br.com.benfatto.jacares.service.PacientesVacinadosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pacientesVacinados")
public class PacientesVacinadosController {
    private final PacientesVacinadosMapper pacientesVacinadosMapper;
    private final PacientesVacinadosService pacientesVacinadosService;

    public PacientesVacinadosController(PacientesVacinadosMapper pacientesVacinadosMapper, PacientesVacinadosService pacientesVacinadosService) {
        this.pacientesVacinadosMapper = pacientesVacinadosMapper;
        this.pacientesVacinadosService = pacientesVacinadosService;
    }

    @PostMapping
    public ResponseEntity<PacientesVacinadosDTO> create(@RequestBody CreatePacientesVacinadosDTO dto){
        PacientesVacinados pacientesVacinados = this.pacientesVacinadosService.create(
                this.pacientesVacinadosMapper.mapToEntity(dto)
        );
        return new ResponseEntity<>(this.pacientesVacinadosMapper.mapToDTO(pacientesVacinados), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<PacientesVacinadosListDTO> findAll(){
        List<PacientesVacinadosDTO> foundPacientesVacinados = this.pacientesVacinadosService.findAll()
                                                            .stream()
                                                            .map(this.pacientesVacinadosMapper::mapToDTO)
                                                            .collect(Collectors.toList());
        return new ResponseEntity<>(new PacientesVacinadosListDTO(foundPacientesVacinados), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacientesVacinadosDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.pacientesVacinadosMapper.mapToDTO(
                                    this.pacientesVacinadosService.findById(id)), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacientesVacinadosDTO> updatePacientesVacinados (@PathVariable Long id, @RequestBody PacientesVacinadosDTO dto){
        PacientesVacinados received =  this.pacientesVacinadosMapper.mapToEntity(dto);
        PacientesVacinados found = this.pacientesVacinadosService.findById(id);
        found.setVacinados(received.getVacinados());
        found.setMunicipio(received.getMunicipio());
        found.setVacina(received.getVacina());
        found.setData(received.getData());
        return new ResponseEntity<>(this.pacientesVacinadosMapper.mapToDTO(
                                    this.pacientesVacinadosService.update(found)),
                                    HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePacientesVacinados(@PathVariable Long id){
        this.pacientesVacinadosService.deleteById(id);
        return new ResponseEntity<>("Resource removed", HttpStatus.OK);
    }

}
