package _com2.F1.services;

import _com2.F1.dtos.EquipeDto;
import _com2.F1.entities.Equipe;
import _com2.F1.entities.Piloto;
import _com2.F1.repositories.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    public List<EquipeDto> listarEquipe() {
        List<Equipe> equipeDtoList = equipeRepository.findAll();
        return equipeDtoList
                .stream()
                .map(e -> new EquipeDto(e))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EquipeDto listarEquipePorId(Long id) {
        Optional<Equipe> equipeId = equipeRepository.findById(id);
        Equipe entity = equipeId.get();
        return new EquipeDto(entity);
    }

    @Transactional
    public EquipeDto inserirEquipe(EquipeDto equipeDto) {
        Equipe equipe = new Equipe();
        equipe.setNome(equipeDto.getNome());
        equipe.setNacionalidade(equipeDto.getNacionalidade());
        equipe.setCarro(equipeDto.getCarro());
        equipe.setTitulos(equipeDto.getTitulos());

        equipe = equipeRepository.save(equipe);
        return new EquipeDto(equipe);

    }
}
