package baby.ey.crying.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CryingRequestsDto {
    private Long id;
    private String path;
    private String content;
    private LocalDateTime created;
}
