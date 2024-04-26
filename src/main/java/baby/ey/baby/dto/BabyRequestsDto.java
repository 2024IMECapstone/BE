package baby.ey.baby.dto;

import baby.ey.user.entity.User;
import lombok.Getter;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
public class BabyRequestsDto {
    private Long id;
    private User parent;
    private String path;
    private String name;
    private Date birthday;
    private Integer gender;
    private LocalDateTime created;
    private LocalDateTime modified;
}