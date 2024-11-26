package backend.organotech.infra.colaborador;

import backend.organotech.entity.colaborador.Colaborador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
    Page<Colaborador> findAllByAtivoTrue(Pageable paginacao);

}
