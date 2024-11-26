package backend.organotech.application.time;

import backend.organotech.entity.post.DadosAtualizacaoPost;
import backend.organotech.entity.post.DadosDetalhamentoPost;
import backend.organotech.entity.post.Post;
import backend.organotech.entity.time.DadosAtualizacaoTime;
import backend.organotech.entity.time.DadosCadastroTime;
import backend.organotech.entity.time.DadosDetalhamentoTime;
import backend.organotech.entity.time.Time;
import backend.organotech.infra.time.TimeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeService {

    @Autowired
    private TimeRepository repository;

    public DadosDetalhamentoTime cadastrarTime(@Valid DadosCadastroTime dados) {
        var time = new Time(dados.nome(), dados.cor());
        repository.save(time);
            return converteDadosDetalhados(time);
        }

    public List<DadosDetalhamentoTime> listarTimes(Pageable paginacao) {
        Page<Time> times = repository.findAll(paginacao);
        return times.stream().map(this::converteDadosDetalhados).collect(Collectors.toList());
    }

    public DadosDetalhamentoTime atualizarTime(@Valid DadosAtualizacaoTime dados, Long id) {
        var time =  repository.findById(id);
        if (time.isPresent()) {
            var timePresente = time.get();
            if (dados.nome() != null) {
                timePresente.setNome(dados.nome());
            }
            if (dados.cor() != null) {
                timePresente.setCor(dados.cor());
            }

        }
        repository.save(time.get());
        return converteDadosDetalhados(time.get());

    }

    public void desativarTime(Long id){
        var time = repository.findById(id);
        time.ifPresent(c -> c.setAtivo(false));
        repository.save(time.get());
    }



    private DadosDetalhamentoTime converteDadosDetalhados(Time time) {
        return new DadosDetalhamentoTime(
                time.getId(),
                time.getNome(),
                time.getCor()
        );
    }

}


