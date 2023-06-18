package _com2.F1.dtos;

import _com2.F1.entities.Equipe;
import _com2.F1.entities.Piloto;
import lombok.*;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class PilotoDto {
    private Long id;
    private String nome;
    private Integer idade;
    private String nacionalidade;
    private Equipe equipe;
    private Integer titulos;
    private Integer vitorias;

    public PilotoDto(Piloto piloto) {
        this.id = piloto.getId();
        this.nome = piloto.getNome();
        this.idade = piloto.getIdade();
        this.nacionalidade = piloto.getNacionalidade();
        this.equipe = piloto.getEquipe();
        this.titulos = piloto.getTitulos();
        this.vitorias = piloto.getVitorias();
    }
}
