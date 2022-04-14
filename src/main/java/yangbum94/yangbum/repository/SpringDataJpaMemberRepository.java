package yangbum94.yangbum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yangbum94.yangbum.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}
