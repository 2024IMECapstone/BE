package baby.ey.user.entity;

import baby.ey.baby.entity.Baby;
import baby.ey.user.dto.UserRequestsDto;
import baby.ey.user.dto.UserResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "babyid")
    private Baby baby;

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
        this.created = LocalDateTime.now();
        this.modified = LocalDateTime.now();
    }

}
