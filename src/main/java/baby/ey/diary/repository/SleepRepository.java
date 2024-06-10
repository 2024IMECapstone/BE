package baby.ey.diary.repository;

import baby.ey.diary.entity.Sleep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SleepRepository extends JpaRepository<Sleep, Long> {
    List<Sleep> findAllByOrderByCreatedDesc();
    Optional<Sleep> findTopByOrderByCreatedDesc();
}

