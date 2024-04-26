package baby.ey.user.controller;


import baby.ey.user.dto.UserRequestsDto;
import baby.ey.user.dto.UserResponseDto;
import baby.ey.user.entity.User;
import baby.ey.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "User", description = "유저 API, 회원가입")
public class UserController {

    private final UserService userService;
    @GetMapping("/api/user")
    @Operation(summary = "유저 조회", description = "유저 조회 후 리스트 반환 API")
    public List<UserResponseDto> getUser() {
        return userService.getUser();
    }

    @PostMapping("/api/signup")
    @Operation(summary = "회원가입", description = "회원가입 API")
    public UserResponseDto createUser(@RequestBody UserRequestsDto userRequestsDto) {
        return userService.createUser(userRequestsDto);
    }

    @GetMapping("/api/user/{email}")
    @Operation(summary = "이메일로 회원 조회", description = "아이디 찾기 API")
    public UserResponseDto getDiary(@PathVariable String email) {
        return userService.getUser(email);
    }
}
