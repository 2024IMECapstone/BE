package baby.ey.baby.repository;

import baby.ey.baby.entity.Baby;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BabyRepository extends JpaRepository<Baby, Long> {
    List<Baby> findAllByOrderByCreatedDesc();
}