package backend.organotech.entity.post;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPost(
        @NotBlank(message = "Campo titulo não deve ser nulo ou vazio")
        String titulo,

        @NotBlank(message = "Campo texto não deve ser nulo ou vazio")
        String texto,

        String imagem,

        @JsonAlias({"colaborador", "escritor", "colaborador_id", "colaboradorId"})
        @NotNull(message = "Campo autor do texto (colaborador) não deve ser nulo ou vazio")
        Long colaborador_id

) {
}
