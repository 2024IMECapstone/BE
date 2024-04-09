package baby.ey;

import baby.ey.entity.MemberEntity;
import baby.ey.repository.MemberRepository;
import baby.ey.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @MockBean
    private MemberRepository memberRepository;

    @Test
    public void testSaveMember() {
        // given
        MemberEntity memberEntity = MemberEntity.builder()
                .userid("taromom")
                .password("taromom1234")
                .email("taro@example.com")
                .nickname("타로맘")
                .relation("mother")
                .build();
        when(memberRepository.save(memberEntity)).thenReturn(memberEntity);

        // when
        memberService.saveMember();

        // then
        verify(memberRepository, times(1)).save(memberEntity);
    }
}
