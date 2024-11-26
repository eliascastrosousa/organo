package backend.organotech.entity.colaborador;
import backend.organotech.entity.time.Time;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "colaboradores")
@Entity(name = "Colaborador")
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cargo;
    private String imagem;
    private Boolean ativo;
    private Boolean favorito;
    private LocalDate dataAdmissao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "time_id")
    private Time time;


    public Colaborador(String nome, String cargo, String imagem, Time time) {
        this.nome = nome;
        this.cargo = cargo;
        this.imagem = imagem;
        this.time = time;
        this.favorito = false;
        this.ativo = true;
        this.dataAdmissao = LocalDate.now();
    }
}
