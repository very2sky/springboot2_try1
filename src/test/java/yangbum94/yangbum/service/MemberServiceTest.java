package yangbum94.yangbum.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yangbum94.yangbum.domain.Member;
import yangbum94.yangbum.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }
    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId= memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test
    public void 중복회원예외(){
        Member member1= new Member();
        member1.setName("spring1");

        Member member2= new Member();
        member2.setName("spring1");

        memberService.join(member1);
        assertThrows(IllegalStateException.class ,()-> memberService.join(member2));
     /*   try{
            memberService.join(member2);
            fail();
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/
    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}