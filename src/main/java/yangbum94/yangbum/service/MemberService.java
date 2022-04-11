package yangbum94.yangbum.service;

import yangbum94.yangbum.domain.Member;
import yangbum94.yangbum.repository.MemberRepository;
import yangbum94.yangbum.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService  {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        validateDuplicatedMember(member);//중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicatedMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m ->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    /*

      전체회원
    */
    public List<Member> findMembers(){
         return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}