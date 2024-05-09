package baby.ey.baby.entity;

import baby.ey.baby.dto.BabyRequestsDto;
import baby.ey.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor

public class Baby extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String babyid;

    @Column
    private String path;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date birthday;

    @Column(nullable = false)
    private Integer gender;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    public Baby(BabyRequestsDto babyRequestsDto) {
        this.id = babyRequestsDto.getId();
        this.babyid = babyRequestsDto.getBabyid();
        this.path = babyRequestsDto.getPath();
        this.name = babyRequestsDto.getName();
        this.birthday = babyRequestsDto.getBirthday();
        this.gender = babyRequestsDto.getGender();
        this.created = LocalDateTime.now();
        this.modified = LocalDateTime.now();
    }
}