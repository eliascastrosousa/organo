package backend.organotech.entity.time;

public record DadosListagemTimes(Long id, String nome, String cor) {
    public DadosListagemTimes(Time time){
        this(time.getId(), time.getNome(), time.getCor());
    }
}
