package br.com.benfatto.jacares.controller;

import br.com.benfatto.jacares.dto.CreateMunicipioDTO;
import br.com.benfatto.jacares.dto.MunicipioDTO;
import br.com.benfatto.jacares.dto.MunicipioListDTO;
import br.com.benfatto.jacares.mapper.MunicipioMapper;
import br.com.benfatto.jacares.model.Municipio;
import br.com.benfatto.jacares.service.EstadoService;
import br.com.benfatto.jacares.service.MunicipioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/municipios")
public class MunicipioController {
    private final MunicipioService municipioService;
    private final MunicipioMapper municipioMapper;

    public MunicipioController(MunicipioService municipioService,
                               MunicipioMapper municipioMapper) {
        this.municipioService = municipioService;
        this.municipioMapper = municipioMapper;
    }

    @PostMapping
    public ResponseEntity<MunicipioDTO> create(@RequestBody CreateMunicipioDTO dto){
        Municipio municipio = this.municipioService.create(
            this.municipioMapper.mapToEntity(dto)
        );
        return new ResponseEntity<>(this.municipioMapper.mapToDTO(municipio), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<MunicipioListDTO> findAll(){
        List<MunicipioDTO> foundMunicipios= this.municipioService.findAll()
                                .stream()
                                .map(this.municipioMapper::mapToDTO)
                                .collect(Collectors.toList());
        return new ResponseEntity<>(new MunicipioListDTO(foundMunicipios), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MunicipioDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.municipioMapper.mapToDTO(this.municipioService.findById(id)), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MunicipioDTO> updateMunicipio(@PathVariable Long id,@RequestBody CreateMunicipioDTO dto){
        Municipio receivedMunicipio = this.municipioMapper.mapToEntity(dto);
        Municipio foundMunicipio = this.municipioService.findById(id);
        foundMunicipio.setNome(receivedMunicipio.getNome());
        foundMunicipio.setEstado(receivedMunicipio.getEstado());
        return new ResponseEntity<>(this.municipioMapper.mapToDTO(
                                    this.municipioService.update(foundMunicipio)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMunicipio(@PathVariable Long id){
        this.municipioService.deleteById(id);
        return new ResponseEntity<>("Resource removed", HttpStatus.OK);
    }

}
