package _com2.F1.controllers;

import _com2.F1.dtos.PilotoDto;
import _com2.F1.dtos.PistaDto;
import _com2.F1.entities.Pista;
import _com2.F1.services.PistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "pistas")
public class PistaController {

    @Autowired
    private PistaService pistaService;

    @GetMapping
    public ResponseEntity<List<PistaDto>> buscarPistas(){
        List<PistaDto> pistas = pistaService.listarPistas();
        return ResponseEntity.ok(pistas);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PistaDto> obterPistaPorId(@PathVariable Long id) {
        PistaDto pista = pistaService.listarPistasPorId(id);
        return ResponseEntity.ok().body(pista);
    }
    @PostMapping
    public ResponseEntity<PistaDto> inserirPista(@RequestBody PistaDto pistaDto){
        pistaDto = pistaService.inserirPista(pistaDto);
        return ResponseEntity.ok().body(pistaDto);
    }
}
