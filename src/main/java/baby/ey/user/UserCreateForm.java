package baby.ey.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
    @Size(min=3, max=25)
    @NotEmpty(message = "닉네임을 입력해주세요.")
    private String nickname;

    @Email
    @NotEmpty(message = "이메일을 입력해주세요.")
    private String email;

    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String password1;

    @NotEmpty(message = "비밀번호를 확인해주세요.")
    private String password2;

    @NotEmpty(message = "관계를 입력해주세요.")
    private Integer relation;

}