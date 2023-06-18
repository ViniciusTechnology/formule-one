package _com2.F1.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_pista")
public class Pista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String país;
    private Integer voltas;
}
