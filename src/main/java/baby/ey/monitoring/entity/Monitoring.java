package baby.ey.monitoring.entity;

import baby.ey.monitoring.dto.MonitoringRequestsDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Monitoring extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @Column
    private LocalDateTime created;

    public Monitoring(MonitoringRequestsDto requestDto) {
        this.id = requestDto.getId();
        this.content = requestDto.getContent();
        this.created = LocalDateTime.now();
    }
}
