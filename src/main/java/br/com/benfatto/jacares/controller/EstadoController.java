package br.com.benfatto.jacares.controller;

import br.com.benfatto.jacares.dto.CreateEstadoDTO;
import br.com.benfatto.jacares.dto.EstadoDTO;
import br.com.benfatto.jacares.mapper.EstadoMapper;
import br.com.benfatto.jacares.model.Estado;
import br.com.benfatto.jacares.service.EstadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {
    private final EstadoService estadoService;
    private final EstadoMapper estadoMapper;

    //Injecao de dependencia via construtor
    public EstadoController(EstadoService estadoService, EstadoMapper estadoMapper){
        this.estadoService = estadoService;
        this.estadoMapper= estadoMapper;
    }

    @GetMapping
    public ResponseEntity<List<EstadoDTO>> findAll(){
        List<EstadoDTO> estados = this.estadoService.findAll()
                .stream()
                .map(this.estadoMapper::convertToDTO) //Mapeando os itens para um DTO
                .collect(Collectors.toList()); //Coleta tudo como uma lista

        return new ResponseEntity<>(estados, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoDTO> findById(@PathVariable Long id){
        Estado estado = this.estadoService.findById(id);
        return new ResponseEntity<>(this.estadoMapper.convertToDTO(estado), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EstadoDTO> create(@RequestBody EstadoDTO dto){
        Estado createdEstado = this.estadoService.create(this.estadoMapper.convertToEntity(dto));
        return new ResponseEntity<>(this.estadoMapper.convertToDTO(createdEstado), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoDTO> update(@PathVariable Long id, @RequestBody EstadoDTO dto){
        Estado estado = this.estadoService.findById(id); //Busca o cara no banco
        estado.setNome(dto.getNome());
        estado.setSigla(dto.getUf());
        return new ResponseEntity<>(this.estadoMapper.convertToDTO(this.estadoService.update(estado)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        Estado estado = this.estadoService.findById(id);
        this.estadoService.delete(estado);
        return new ResponseEntity<>("Resource removed", HttpStatus.OK);
    }

}
