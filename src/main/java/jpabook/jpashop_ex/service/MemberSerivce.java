package jpabook.jpashop_ex.service;

import jpabook.jpashop_ex.domain.Member;
import jpabook.jpashop_ex.repository.MemberRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberSerivce {

    private final MemberRespository memberRespository;

    // 회원 가입
    @Transactional
    public Long join(Member member) {

        validateDuplicateMember(member); // 중복 회원 검증
        memberRespository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRespository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회
    public List<Member> findMembers() {
        return memberRespository.findAll();
    }

    public Member findMember(Long memberId) {
        return memberRespository.findOne(memberId);
    }

    @Transactional
    public void update(Long id, String name) {
        Member member = memberRespository.findOne(id);
        member.setName(name);
    }
}
