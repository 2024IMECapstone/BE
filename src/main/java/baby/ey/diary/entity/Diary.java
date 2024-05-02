package baby.ey.diary.entity;

import baby.ey.diary.dto.DiaryRequestsDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Diary extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long baby_id;

    @Column(nullable = false)
    private String content;

    @Column
    private String path;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    // 이미지 추가

    public Diary(DiaryRequestsDto requestsDto) {
        this.id = requestsDto.getId();
        this.baby_id = requestsDto.getBaby_id();
        this.content = requestsDto.getContent();
        this.path = requestsDto.getPath();
        this.created = LocalDateTime.now();
        this.modified = LocalDateTime.now();
    }

    public void update(DiaryRequestsDto requestsDto) {
        this.content = requestsDto.getContent();
        this.path = requestsDto.getPath();
        this.modified = LocalDateTime.now();
    }
}
