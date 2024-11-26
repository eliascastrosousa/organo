package backend.organotech.entity.post;

import backend.organotech.entity.colaborador.Colaborador;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "posts")
@Entity(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String texto;
    private String imagem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;

    private Boolean ativo;
    private LocalDateTime dataCriacao;



    public Post(String titulo, String texto, String imagem, Colaborador colaborador) {
        this.titulo = titulo;
        this.texto = texto;
        this.imagem = imagem;
        this.colaborador = colaborador;
        this.ativo = true;
        this.dataCriacao = LocalDateTime.now();
    }
}
