package baby.ey.user.dto;

import baby.ey.baby.entity.Baby;
import jakarta.persistence.Column;
import lombok.Getter;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
public class UserRequestsDto {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private Date birthday;
    private Integer relation;
    private String babyid;
    private LocalDateTime created;
    private LocalDateTime modified;
}
