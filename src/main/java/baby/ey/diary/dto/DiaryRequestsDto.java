package baby.ey.diary.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DiaryRequestsDto {
    private Long id;
    private Long baby_id;
    private String content;
    private String path;
    private LocalDateTime created;
    private LocalDateTime modified;
}
