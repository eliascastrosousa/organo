package backend.organotech.entity.colaborador;

import backend.organotech.entity.time.Time;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosCadastroColaborador(
        @NotBlank(message = "Campo nome não deve ser nulo ou vazio")
        String nome,
        @NotBlank(message = "Campo cargo não deve ser nulo ou vazio")
        String cargo,
        @NotBlank(message = "Campo imagem não deve ser nulo ou vazio")
        String imagem,



        @JsonAlias({"time_id", "timeId", "time"})
        @NotNull(message = "Campo time não deve ser nulo ou vazio")
        Long time_id) {
}
