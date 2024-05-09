package baby.ey.baby.dto;

import lombok.Getter;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
public class BabyRequestsDto {
    private Long id;
    private String babyid;
    private String path;
    private String name;
    private Date birthday;
    private Integer gender;
    private LocalDateTime created;
    private LocalDateTime modified;
}