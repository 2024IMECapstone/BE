package baby.ey.baby.dto;

import baby.ey.baby.entity.Baby;
import baby.ey.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor

public class BabyResponseDto {
    private Long id;
    private String babyid;
    // private User user;
    private String path;
    private String name;
    private Date birthday;
    private Integer gender;
    private LocalDateTime created;
    private LocalDateTime modified;

    @Builder
    public BabyResponseDto(Baby entity) {
        this.id = entity.getId();
        this.babyid = entity.getBabyid();
        // this.user = entity.getUser();
        this.path = entity.getPath();
        this.name = entity.getName();
        this.birthday = entity.getBirthday();
        this.gender = entity.getGender();
        this.created = LocalDateTime.now();
        this.modified = LocalDateTime.now();
    }
}
