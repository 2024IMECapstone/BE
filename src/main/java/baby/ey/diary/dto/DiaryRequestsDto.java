package baby.ey.diary.dto;

import lombok.Getter;

@Getter
public class DiaryRequestsDto {
    private Long id;
    private Long baby_id;
    private String content;

    // 이미지 추가
}
