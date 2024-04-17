package baby.ey.user.entity;

import baby.ey.user.dto.UserRequestsDto;
import baby.ey.user.dto.UserResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class User extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column
    private Date birthday;

    @Column
    private Integer relation;

    @Column
    private String baby_id;
    // FK 연결 예정

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    public User(UserRequestsDto userRequestsDto) {
        this.id = userRequestsDto.getId();
        this.email = userRequestsDto.getEmail();
        this.password = userRequestsDto.getPassword();
        this.nickname = userRequestsDto.getNickname();
        this.birthday = userRequestsDto.getBirthday();
        this.relation = userRequestsDto.getRelation();
        this.baby_id = userRequestsDto.getBaby_id();
        this.created = LocalDateTime.now();
        this.modified = LocalDateTime.now();
    }


}
