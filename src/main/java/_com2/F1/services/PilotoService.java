package _com2.F1.services;

import _com2.F1.dtos.EquipeDto;
import _com2.F1.dtos.PilotoDto;
import _com2.F1.entities.Equipe;
import _com2.F1.entities.Piloto;
import _com2.F1.repositories.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PilotoService {

    @Autowired
    private PilotoRepository pilotoRepository;


    public List<PilotoDto> listarPilotos(){
        List<Piloto> listaPilotos = pilotoRepository.findAll();
        return listaPilotos
                .stream()
                .map(x -> new PilotoDto(x))
                .collect(Collectors.toList());

    }
    @Transactional(readOnly = true)
    public PilotoDto listarPilotosPorId(Long id) {
        Optional<Piloto> pilotoId = pilotoRepository.findById(id);
        Piloto entity = pilotoId.get();
        return new PilotoDto(entity);
    }

    public PilotoDto inserirPiloto(PilotoDto pilotoDto){
            Piloto piloto = new Piloto();
            piloto.setNome(pilotoDto.getNome());
            piloto.setIdade(pilotoDto.getIdade());
            piloto.setNacionalidade(pilotoDto.getNacionalidade());
            piloto.setTitulos(pilotoDto.getTitulos());
            piloto.setVitorias(pilotoDto.getVitorias());

            piloto = pilotoRepository.save(piloto);
            return new PilotoDto(piloto);
        }
}
