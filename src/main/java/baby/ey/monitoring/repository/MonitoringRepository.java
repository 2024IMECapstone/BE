package baby.ey.monitoring.repository;

import baby.ey.monitoring.entity.Monitoring;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonitoringRepository extends JpaRepository<Monitoring, Long> {
    List<Monitoring> findAllByOrderByCreatedDesc();
}
