package backend.organotech.entity.post;

import backend.organotech.entity.colaborador.Colaborador;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosDetalhamentoPost(
        Long id,
        String titulo,
        String texto,
        String imagem,
        String colaborador

)
         {
    public DadosDetalhamentoPost (Post post){
        this(
                post.getId(),
                post.getTitulo(),
                post.getTexto(),
                post.getImagem(),
                post.getColaborador().getNome()
                );
    }


}
