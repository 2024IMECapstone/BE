package baby.ey.diary.repository;

import baby.ey.diary.entity.Growth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GrowthRepository extends JpaRepository<Growth, Long> {
    List<Growth> findAllByOrderByCreatedDesc();
}

