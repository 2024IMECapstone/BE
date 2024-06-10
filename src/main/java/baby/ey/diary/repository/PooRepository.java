package baby.ey.diary.repository;

import baby.ey.diary.entity.Poo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PooRepository extends JpaRepository<Poo, Long> {
    List<Poo> findAllByOrderByCreatedDesc();
    Optional<Poo> findTopByOrderByCreatedDesc();
}
