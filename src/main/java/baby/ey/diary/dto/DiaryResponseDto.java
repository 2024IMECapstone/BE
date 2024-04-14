package baby.ey.diary.dto;

import baby.ey.diary.entity.Diary;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class DiaryResponseDto {
    private Long id;
    private Long baby_id;
    private String content;
    private LocalDateTime created;
    private LocalDateTime modified;


    @Builder
    public DiaryResponseDto(Diary entity) {
        this.id = entity.getId();
        this.baby_id = entity.getBaby_id();
        this.content = entity.getContent();
        this.created = entity.getCreated();
        this.modified = entity.getModified();
    }

}
