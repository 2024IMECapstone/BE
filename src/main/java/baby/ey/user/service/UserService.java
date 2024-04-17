package baby.ey.user.service;

import baby.ey.diary.dto.DiaryResponseDto;
import baby.ey.user.dto.UserRequestsDto;
import baby.ey.user.dto.UserResponseDto;
import baby.ey.user.entity.User;
import baby.ey.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserResponseDto> getUser() {
        return userRepository.findAllByOrderByCreatedDesc().stream()
                .map(UserResponseDto::new).toList();
    }

    @Transactional
    public UserResponseDto createUser(UserRequestsDto userRequestsDto) {
        User user = new User(userRequestsDto);
        userRepository.save(user);
        return new UserResponseDto(user);
    }

    @Transactional
    public UserResponseDto getUser(String email) {
        return userRepository.findByEmail(email).map(UserResponseDto::new).orElseThrow(
                () -> new IllegalArgumentException("해당 가입 정보가 없습니다.")
        );
    }
}
