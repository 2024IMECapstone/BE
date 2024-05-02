package baby.ey.monitoring.dto;

import lombok.Getter;
import org.springframework.cglib.core.Local;

@Getter
public class MonitoringRequestsDto {
    private Long id;
    private String content;
    private Local created;
}
