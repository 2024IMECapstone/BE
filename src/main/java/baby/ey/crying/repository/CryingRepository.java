package baby.ey.crying.repository;

import baby.ey.crying.entity.Crying;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CryingRepository extends JpaRepository<Crying, Long> {
    List<Crying> findAllByOrderByCreatedDesc();
}
