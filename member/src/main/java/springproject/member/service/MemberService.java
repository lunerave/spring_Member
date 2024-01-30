package springproject.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springproject.member.dto.MemberDTO;
import springproject.member.entity.MemberEntity;
import springproject.member.repository.MemberRepository;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public MemberDTO login(MemberDTO memberDTO) {
        /*
            1. 회원이 입력한 이메일로 DB 조회
            2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
         */
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if (byMemberEmail.isPresent()) {
            // 회원 정보 조회 성공
            MemberEntity memberEntity = byMemberEmail.get();
            if (memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {
                // 비밀번호 일치
                // entity -> dto 변환 후 리턴
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            } else {
                // 비밀번호 입력 실패
                return null;
            }
        } else {
            // 회원 정보 없음 == 잘못된 이메일 or 비회원
            return null;
        }
    }

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();

        for (MemberEntity memberEntity: memberEntityList) {
            memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
        }

        return memberDTOList;
    }
}
