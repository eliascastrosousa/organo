package backend.organotech.application.post;

import backend.organotech.entity.post.DadosAtualizacaoPost;
import backend.organotech.entity.post.DadosCadastroPost;
import backend.organotech.entity.post.DadosDetalhamentoPost;
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
@RequestMapping("/posts")
public class PostController {



    @Autowired
    private PostService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoPost> cadastrarPost(@RequestBody @Valid DadosCadastroPost dados, UriComponentsBuilder uriBuilder){
        var post = service.cadastrarPost(dados);
        var uri = uriBuilder.path("post/{id}").buildAndExpand(post.id()).toUri();
        return ResponseEntity.created(uri).body(post);
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoPost>> listarPost(@PageableDefault(size = 20, sort = {"id"}) Pageable paginacao){
        var page = service.listarPosts(paginacao);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoPost> atualizarPost(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoPost dados){
        var post = service.atualizarPost(dados,id );
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarPost(@PathVariable Long id) {
        service.apagarPost(id);
        return ResponseEntity.noContent().build();
    }

}
