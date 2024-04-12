//package baby.ey.service;
//
//import baby.ey.domain.Member;
//import baby.ey.dto.JwtTokenDTO;
//import baby.ey.repository.MemberRepository;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//import baby.ey.jwt.JwtTokenProvider;
//
//
//import java.util.List;
//import java.util.Optional;
//
//
//public interface MemberService {
//    JwtTokenDTO signIn(String username, String password);
//    Long join(Member member);
//    List<Member> findMembers();
//    Optional<Member> findOne(Long memberId);
//}
//
