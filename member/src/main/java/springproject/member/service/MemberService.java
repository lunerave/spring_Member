package springproject.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springproject.member.dto.MemberDTO;
import springproject.member.entity.MemberEntity;
import springproject.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {
        //1. dto -> entity 변환
        //2. repository의 save 호출 (조건. entity 객체를 넘겨 준다)
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }
}
