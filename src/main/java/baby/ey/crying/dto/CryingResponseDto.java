package baby.ey.crying.dto;

import baby.ey.crying.entity.Crying;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CryingResponseDto {
    private Long id;
    private String path;
    private String content;
    private LocalDateTime created;

    @Builder
    public CryingResponseDto(Crying entity) {
        this.id = entity.getId();
        this.path = entity.getPath();
        this.content = entity.getContent();
        this.created = LocalDateTime.now();
    }
}
