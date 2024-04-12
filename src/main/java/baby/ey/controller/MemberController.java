//package baby.ey.controller;
//
//import baby.ey.domain.Member;
//import baby.ey.dto.JwtTokenDTO;
//import baby.ey.dto.SignInDto;
//import baby.ey.service.MemberService;
//import lombok.RequiredArgsConstructor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/members")
//public class MemberController {
//
//    private final MemberService memberService;
//    private static final Logger log = LoggerFactory.getLogger(MemberController.class);
//
//    @PostMapping("/sign-in")
//    public JwtTokenDTO signIn(@RequestBody SignInDto signInDto) {
//        String username = signInDto.getUsername();
//        String password = signInDto.getPassword();
//        JwtTokenDTO jwtToken = memberService.signIn(username, password);
//        log.info("request username = {}, password = {}", username, password);
//        log.info("jwtToken accessToken = {}, refreshToken = {}", jwtToken.getAccessToken(), jwtToken.getRefreshToken());
//        return jwtToken;
//    }
//
//    @PostMapping("/test")
//    public String test() {
//        return "success";
//    }
//
//}
