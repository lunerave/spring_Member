package springproject.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springproject.member.dto.MemberDTO;
import springproject.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {
    }
}
