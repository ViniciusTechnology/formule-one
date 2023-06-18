package _com2.F1.dtos;

import _com2.F1.entities.Pista;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class PistaDto {
    private Long id;
    private String nome;
    private String país;
    private Integer voltas;

    public PistaDto(Pista entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.país = entity.getPaís();
        this.voltas = entity.getVoltas();
    }
}

