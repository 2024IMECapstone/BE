package baby.ey.monitoring.service;

import baby.ey.monitoring.dto.MonitoringRequestsDto;
import baby.ey.monitoring.dto.MonitoringResponseDto;
import baby.ey.monitoring.entity.Monitoring;
import baby.ey.monitoring.repository.MonitoringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor

public class MonitoringService {
    private final MonitoringRepository monitoringRepository;

    @Transactional(readOnly = true)
    public List<MonitoringResponseDto> getMonitoring() {
        return monitoringRepository.findAllByOrderByCreatedDesc().stream()
                .map(MonitoringResponseDto::new).toList();
    }

    @Transactional
    public MonitoringResponseDto createMonitoring(MonitoringRequestsDto requestDto) {
        Monitoring monitoring = new Monitoring(requestDto);
        monitoringRepository.save(monitoring);
        return new MonitoringResponseDto(monitoring);
    }
}
