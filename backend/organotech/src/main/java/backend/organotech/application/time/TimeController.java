package backend.organotech.application.time;
import backend.organotech.entity.time.DadosAtualizacaoTime;
import backend.organotech.entity.time.DadosCadastroTime;
import backend.organotech.entity.time.DadosDetalhamentoTime;
import backend.organotech.entity.time.DadosListagemTimes;
import backend.organotech.infra.time.TimeRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeRepository repository;

    @Autowired
    private TimeService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoTime> cadastrar(@RequestBody @Valid DadosCadastroTime dados, UriComponentsBuilder uriBuilder){
        var time = service.cadastrarTime(dados);
        var uri = uriBuilder.path("/time/{id}").buildAndExpand(time.id()).toUri();
        return ResponseEntity.created(uri).body(time);
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoTime>> listarTimes(@PageableDefault(size = 20, sort = {"id"}) Pageable paginacao){
        var page = service.listarTimes(paginacao);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoTime> atualizarCadastro(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTime dados){
        var time = service.atualizarTime(dados, id);
        return ResponseEntity.ok(time);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarItem(@PathVariable Long id) {
        service.desativarTime(id);
        return ResponseEntity.noContent().build();
    }

}
