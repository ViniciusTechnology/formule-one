package _com2.F1.dtos;

import _com2.F1.entities.Equipe;
import _com2.F1.entities.Piloto;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class EquipeDto {
    private Long id;
    private String nome;
    private String nacionalidade;
    private Set<Piloto> pilotos;
    private String carro;
    private Integer titulos;

    public EquipeDto(Equipe equipe) {
        this.id = equipe.getId();
        this.nome = equipe.getNome();
        this.nacionalidade = equipe.getNacionalidade();
        this.pilotos = equipe.getPilotos();
        this.carro = equipe.getCarro();
        this.titulos = equipe.getTitulos();
    }
}
