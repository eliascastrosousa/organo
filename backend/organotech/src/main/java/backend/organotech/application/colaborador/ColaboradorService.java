package backend.organotech.application.colaborador;

import backend.organotech.entity.colaborador.Colaborador;
import backend.organotech.entity.colaborador.DadosAtualizacaoColaborador;
import backend.organotech.entity.colaborador.DadosCadastroColaborador;
import backend.organotech.entity.colaborador.DadosDetalhamentoColaborador;
import backend.organotech.infra.colaborador.ColaboradorRepository;
import backend.organotech.infra.time.TimeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColaboradorService {

    @Autowired
    private TimeRepository timeRepository;
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public DadosDetalhamentoColaborador cadastrarColaborador(DadosCadastroColaborador dados) {
        var time = timeRepository.findById(dados.time_id());
        if (time.isPresent()) {
            var colaborador = new Colaborador(dados.nome(), dados.cargo(), dados.imagem(), time.get());
            colaboradorRepository.save(colaborador);
            return converteDadosDetalhados(colaborador);
        }
        return null;
    }

    public List<DadosDetalhamentoColaborador> listarColaboradores(Pageable paginacao) {
        Page<Colaborador> colaboradores = colaboradorRepository.findAllByAtivoTrue(paginacao);
        return colaboradores.stream().map(this::converteDadosDetalhados).collect(Collectors.toList());
    }

    public DadosDetalhamentoColaborador atualizarColaborador(@Valid DadosAtualizacaoColaborador dados, Long id) {
        var colaborador = colaboradorRepository.findById(id);
        if (colaborador.isPresent()) {
            var colaboradorPresente = colaborador.get();
            if (dados.nome() != null) {
                colaboradorPresente.setNome(dados.nome());
            }
            if (dados.cargo() != null) {
                colaboradorPresente.setCargo(dados.cargo());
            }
            if (dados.imagem() != null) {
                colaboradorPresente.setImagem(dados.imagem());
            }
        }
        colaboradorRepository.save(colaborador.get());
        return converteDadosDetalhados(colaborador.get());
    }


    public void desligarColaborador(Long id){
        var colaborador = colaboradorRepository.findById(id);
        colaborador.ifPresent(c -> c.setAtivo(false));
        colaboradorRepository.save(colaborador.get());
    }


    private DadosDetalhamentoColaborador converteDadosDetalhados(Colaborador colaborador) {
        return new DadosDetalhamentoColaborador(
                colaborador.getId(),
                colaborador.getNome(),
                colaborador.getCargo(),
                colaborador.getImagem(),
                colaborador.getTime().getNome());
    }

}