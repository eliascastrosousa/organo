package backend.organotech.application.post;

import backend.organotech.entity.post.DadosAtualizacaoPost;
import backend.organotech.entity.post.DadosCadastroPost;
import backend.organotech.entity.post.DadosDetalhamentoPost;
import backend.organotech.entity.post.Post;
import backend.organotech.infra.colaborador.ColaboradorRepository;
import backend.organotech.infra.post.PostRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public DadosDetalhamentoPost cadastrarPost( DadosCadastroPost dados) {
        var colaborador = colaboradorRepository.findById(dados.colaborador_id());

        if (colaborador.isPresent()) {
            var post = new Post(dados.titulo(), dados.texto(), dados.imagem(), colaborador.get());
            postRepository.save(post);
            return converteDadosDetalhados(post);
        }
        return null;
    }

    public List<DadosDetalhamentoPost> listarPosts(Pageable paginacao){
        System.out.println("passando aqui");
        Page<Post> posts = postRepository.findAllByAtivoTrue(paginacao);
        System.out.println("passou pelo find all");
        return posts.stream().map(this::converteDadosDetalhados).collect(Collectors.toList());
    }

    public DadosDetalhamentoPost atualizarPost(@Valid DadosAtualizacaoPost dados, Long id) {
        var post = postRepository.findById(id);
        if (post.isPresent()) {
            var postPresente = post.get();
            if (dados.titulo() != null) {
                postPresente.setTitulo(dados.titulo());
            }
            if (dados.texto() != null) {
                postPresente.setTexto(dados.texto());
            }
            if (dados.imagem() != null) {
                postPresente.setImagem(dados.imagem());
            }
        }

        postRepository.save(post.get());
        return converteDadosDetalhados(post.get());
    }

    public void apagarPost(Long id) {
        var post = postRepository.findById(id);
        post.ifPresent(value -> postRepository.delete(value));
    }

    private DadosDetalhamentoPost converteDadosDetalhados(Post post) {
        return new DadosDetalhamentoPost(
                post.getId(),
                post.getTitulo(),
                post.getTexto(),
                post.getImagem(),
                post.getColaborador().getNome()
        );
    }
}
