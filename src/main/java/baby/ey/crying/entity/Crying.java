package baby.ey.crying.entity;

import baby.ey.crying.dto.CryingRequestsDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Crying extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String path;

    @Column
    private String content;

    @Column
    private LocalDateTime created;

    public Crying(CryingRequestsDto requestDto) {
        this.id = requestDto.getId();
        this.path = requestDto.getPath();
        this.content = requestDto.getContent();
        this.created = LocalDateTime.now();
    }
}
