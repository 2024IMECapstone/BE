package baby.ey.diary.dto;

import baby.ey.diary.entity.Diary;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class DiaryResponseDto {
    private Long id;
    private Long baby_id;
    private String content;
    private LocalDate createdAt;
    private LocalDate modifiedAt;

    @Builder
    public DiaryResponseDto(Diary entity) {
        this.id = id;
        this.baby_id = baby_id;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
