//package baby.ey.service;
//
//import baby.ey.domain.Member;
//import baby.ey.dto.JwtTokenDTO;
//import baby.ey.jwt.JwtTokenProvider;
//import baby.ey.repository.MemberRepository;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//public class MemberServiceImpl implements MemberService {
//
//    private final MemberRepository memberRepository;
//    private final AuthenticationManager authenticationManager;
//    private final JwtTokenProvider jwtTokenProvider;
//
//    @Override
//    public JwtTokenDTO signIn(String username, String password) {
//        // 사용자 인증
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        // JWT 토큰 생성
//        return jwtTokenProvider.generateToken(authentication);
//    }
//
//    @Override
//    public Long join(Member member) {
//        validateDuplicateMember(member);
//        memberRepository.save(member);
//        return member.getId();
//    }
//
//    private void validateDuplicateMember(Member member) {
//        memberRepository.findByUserid(member.getUserid())
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 이메일입니다.");
//                });
//    }
//
//    @Override
//    public List<Member> findMembers() {
//        return memberRepository.findAll();
//    }
//
//    @Override
//    public Optional<Member> findOne(Long memberId) {
//        return memberRepository.findById(memberId);
//    }
//}
