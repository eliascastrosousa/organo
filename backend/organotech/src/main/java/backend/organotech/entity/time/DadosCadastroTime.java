package backend.organotech.entity.time;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTime(
        @NotBlank(message = "Campo nome nao deve ser vazio.")
        String nome,
        @NotBlank(message = "Campo cor nao deve ser vazio.")
        String cor) {
        //colocar validações como qtd de caracteres no item cor.
}