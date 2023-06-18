package _com2.F1.services;

import _com2.F1.dtos.PilotoDto;
import _com2.F1.dtos.PistaDto;
import _com2.F1.entities.Pista;
import _com2.F1.repositories.PistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PistaService {
    @Autowired
    private PistaRepository pistaRepository;

    public List<PistaDto> listarPistas() {
        List<Pista> listaPistas = pistaRepository.findAll();
        return listaPistas
                .stream()
                .map(PistaDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PistaDto listarPistasPorId(Long id) {
        Optional<Pista> pistaId = pistaRepository.findById(id);
        Pista entity = pistaId.get();
        return new PistaDto(entity);
    }
    public PistaDto inserirPista(PistaDto pistaDto){
        Pista pista = new Pista();
        pista.setNome(pista.getNome());
        pista.setPaís(pistaDto.getPaís());
        pista.setVoltas(pistaDto.getVoltas());
        pista = pistaRepository.save(pista);
        return new PistaDto(pista);
    }
}