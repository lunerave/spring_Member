package springproject.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import springproject.member.entity.MemberEntity;

@Getter @Setter
@NoArgsConstructor
@ToString
public class MemberDTO {
    private Long memberId;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setMemberId(memberEntity.getMemberId());
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDTO.setMemberName(memberEntity.getMemberName());

        return memberDTO;
    }

}
