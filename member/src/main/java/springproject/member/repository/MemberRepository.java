package springproject.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springproject.member.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}
