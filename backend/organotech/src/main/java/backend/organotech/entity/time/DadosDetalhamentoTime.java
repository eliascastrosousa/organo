package backend.organotech.entity.time;

public record DadosDetalhamentoTime(Long id, String nome, String cor) {
    public DadosDetalhamentoTime(Time time){
        this(time.getId(), time.getNome(), time.getCor());
    }
}
