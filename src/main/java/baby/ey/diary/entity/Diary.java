package baby.ey.diary.entity;

import baby.ey.diary.dto.DiaryRequestsDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Entity
@Getter
@NoArgsConstructor
public class Diary extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long baby_id;

    @Column(nullable = false)
    private String content;

    // 이미지 추가

    public Diary(DiaryRequestsDto requestsDto) {
        this.id = requestsDto.getId();
        this.baby_id = requestsDto.getBaby_id();
        this.content = requestsDto.getContent();
    }

    public void update(DiaryRequestsDto requestsDto) {
        this.content = requestsDto.getContent();
    }
}
