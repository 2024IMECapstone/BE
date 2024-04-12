//package baby.ey.repository;
//
//import baby.ey.domain.Member;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//import java.util.function.Function;
//
//@Repository
//public class MemoryMemberRepository implements MemberRepository {
//
//    private static Map<Long, Member> store = new HashMap<>();
//    private static long sequence = 0L; // 0, 1, 2 ... 키 값을 생성
//
//    @Override
//    public Member save(Member member) {
//        member.setId(++sequence);
//        store.put(member.getId(), member);
//        return member;
//    }
//
//    @Override
//    public Optional<Member> findById(Long id) {
//        return Optional.ofNullable(store.get(id));
//    }
//
//    @Override
//    public boolean existsById(Long aLong) {
//        return false;
//    }
//
//    @Override
//    public Optional<Member> findByUserid(String userid) {
//        return store.values().stream()
//                .filter(member -> member.getUserid().equals(userid))
//                .findAny();
//    }
//
//    @Override
//    public <S extends Member> List<S> saveAll(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public List<Member> findAll() {
//        return new ArrayList<>(store.values());
//    }
//
//    @Override
//    public List<Member> findAllById(Iterable<Long> longs) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//
//    }
//
//    @Override
//    public void delete(Member entity) {
//
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends Long> longs) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends Member> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    public void clearStore() {
//        store.clear();
//    }
//
//    @Override
//    public void flush() {
//
//    }
//
//    @Override
//    public <S extends Member> S saveAndFlush(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends Member> List<S> saveAllAndFlush(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public void deleteAllInBatch(Iterable<Member> entities) {
//
//    }
//
//    @Override
//    public void deleteAllByIdInBatch(Iterable<Long> longs) {
//
//    }
//
//    @Override
//    public void deleteAllInBatch() {
//
//    }
//
//    @Override
//    public Member getOne(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public Member getById(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public Member getReferenceById(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public <S extends Member> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends Member> List<S> findAll(Example<S> example) {
//        return null;
//    }
//
//    @Override
//    public <S extends Member> List<S> findAll(Example<S> example, Sort sort) {
//        return null;
//    }
//
//    @Override
//    public <S extends Member> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends Member> long count(Example<S> example) {
//        return 0;
//    }
//
//    @Override
//    public <S extends Member> boolean exists(Example<S> example) {
//        return false;
//    }
//
//    @Override
//    public <S extends Member, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
//        return null;
//    }
//
//    @Override
//    public List<Member> findAll(Sort sort) {
//        return null;
//    }
//
//    @Override
//    public Page<Member> findAll(Pageable pageable) {
//        return null;
//    }
//}
