package backend.organotech.application.colaborador;

import backend.organotech.entity.colaborador.*;

import backend.organotech.infra.colaborador.ColaboradorRepository;
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
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoColaborador> cadastrarColaborador(@RequestBody @Valid DadosCadastroColaborador dados, UriComponentsBuilder uriBuilder){
        var colaborador = service.cadastrarColaborador(dados);
        var uri = uriBuilder.path("/colaborador/{id}").buildAndExpand(colaborador.id()).toUri();
        return ResponseEntity.created(uri).body(colaborador);
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoColaborador>> listarColaboradores(@PageableDefault(size = 30, sort = {"id"}) Pageable paginacao){
        var page = service.listarColaboradores(paginacao);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoColaborador> atualizarCadastroColaborador(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoColaborador dados){
        var colaborador = service.atualizarColaborador(dados,id );
        return ResponseEntity.ok(colaborador);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarColaborador(@PathVariable Long id) {
        service.desligarColaborador(id);
        return ResponseEntity.noContent().build();
    }



}
