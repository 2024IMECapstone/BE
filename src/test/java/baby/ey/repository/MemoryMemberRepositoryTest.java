package baby.ey.repository;

import baby.ey.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setNickname("taro");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByNickname() {
        Member member1 = new Member();
        member1.setNickname("taro");
        repository.save(member1);

        Member member2 = new Member();
        member2.setNickname("sungchan");
        repository.save(member2);

        Member result = repository.findByNickname("taro").get();

        assertThat(result).isEqualTo(member1);
    }
}
