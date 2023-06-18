package _com2.F1.controllers;

import _com2.F1.dtos.EquipeDto;
import _com2.F1.entities.Equipe;
import _com2.F1.services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/equipes")
public class EquipeController {
    @Autowired
    private EquipeService equipeService;

    @GetMapping
    public ResponseEntity<List<EquipeDto>> listarEquipe() {
        List<EquipeDto> equipes = equipeService.listarEquipe();
        return ResponseEntity.ok().body(equipes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipeDto> obterPilotoPorId(@PathVariable Long id) {
        EquipeDto equipe = equipeService.listarEquipePorId(id);
        return ResponseEntity.ok().body(equipe);
    }

    @PostMapping
    public ResponseEntity<EquipeDto> inserirEquipe(@RequestBody EquipeDto equipeDto) {
        equipeDto = equipeService.inserirEquipe(equipeDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(equipeDto.getId()).toUri();
        return ResponseEntity.created(uri).body(equipeDto);

    }
}
