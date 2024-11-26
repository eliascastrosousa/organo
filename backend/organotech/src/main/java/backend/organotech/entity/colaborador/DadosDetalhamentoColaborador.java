package backend.organotech.entity.colaborador;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosDetalhamentoColaborador(
            Long id,
            String nome,
            String cargo,
            String imagem,
            String nomeTime) {
    public DadosDetalhamentoColaborador (Colaborador colaborador){
        this(
                colaborador.getId(),
                colaborador.getNome(),
                colaborador.getCargo(),
                colaborador.getImagem(),
                colaborador.getTime().getNome());
    }
  }

