package baby.ey.monitoring.dto;

import baby.ey.monitoring.entity.Monitoring;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class MonitoringResponseDto {
    private Long id;
    private String content;
    private LocalDateTime created;

    @Builder
    public MonitoringResponseDto(Monitoring entity) {
        this.id = entity.getId();
        this.content = entity.getContent();
        this.created = LocalDateTime.now();
    }
}
