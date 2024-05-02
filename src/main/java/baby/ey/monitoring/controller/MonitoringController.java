package baby.ey.monitoring.controller;

import baby.ey.monitoring.dto.MonitoringRequestsDto;
import baby.ey.monitoring.dto.MonitoringResponseDto;
import baby.ey.monitoring.service.MonitoringService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Monitoring", description = "육아 모니터링 API")
public class MonitoringController {
    private final MonitoringService monitoringService;

    @GetMapping("/api/monitoring")
    @Operation(summary = "육아 모니터링 조회", description = "육아 모니터링 조회 후 리스트 반환 API")
    public List<MonitoringResponseDto> getMonitoring() {
        return monitoringService.getMonitoring();
    }

    @PostMapping("/api/monitoring/post")
    @Operation(summary = "육아 모니터링 작성", description = "육아 모니터링 작성 API")
    public MonitoringResponseDto createMonitoring(@RequestBody MonitoringRequestsDto requestDto) {
        return monitoringService.createMonitoring(requestDto);
    }
}
