package backend.organotech.infra.time;

import backend.organotech.entity.time.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {
}
