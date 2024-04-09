package baby.ey.repository;

import baby.ey.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Member save(Member member);
    Optional<Member> findById(Long memberId);
    Optional<Member> findByUserid(String userid);
    List<Member> findAll();

    void clearStore();
}
