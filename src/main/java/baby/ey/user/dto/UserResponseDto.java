package baby.ey.user.dto;

import baby.ey.baby.entity.Baby;
import baby.ey.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private Date birthday;
    private Integer relation;
    private String babyid;
    private LocalDateTime created;
    private LocalDateTime modified;

    @Builder
    public UserResponseDto(User entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.nickname = entity.getNickname();
        this.birthday = entity.getBirthday();
        this.relation = entity.getRelation();
        this.babyid = entity.getBabyid();
        this.created = LocalDateTime.now();
        this.modified = LocalDateTime.now();
    }

}