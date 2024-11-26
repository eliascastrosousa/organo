package backend.organotech.entity.time;

import backend.organotech.entity.colaborador.Colaborador;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "times")
@Entity(name = "Time")
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cor;
    private Boolean ativo;

    public Time(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
        this.ativo = true;
    }
}
