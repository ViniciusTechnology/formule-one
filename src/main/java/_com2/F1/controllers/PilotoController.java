package _com2.F1.controllers;

import _com2.F1.dtos.PilotoDto;
import _com2.F1.services.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pilotos")
public class PilotoController {

    @Autowired
    private PilotoService pilotoService;

    @GetMapping
    public ResponseEntity<List<PilotoDto>> buscarPilotos(){
        List<PilotoDto> lista = pilotoService.listarPilotos();
        return ResponseEntity.ok().body(lista);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PilotoDto> obterPilotoPorId(@PathVariable Long id) {
        PilotoDto piloto = pilotoService.listarPilotosPorId(id);
        return ResponseEntity.ok().body(piloto);
    }
    @PostMapping
    public ResponseEntity<PilotoDto> inserirPiloto(@RequestBody PilotoDto pilotoDto){
    pilotoDto = pilotoService.inserirPiloto(pilotoDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pilotoDto.getId()).toUri();
    return ResponseEntity.created(uri).body(pilotoDto);
    }
}
