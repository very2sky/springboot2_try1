package yangbum94.yangbum;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yangbum94.yangbum.repository.MemberRepository;
import yangbum94.yangbum.repository.MemoryMemberRepository;
import yangbum94.yangbum.service.MemberService;

@Configuration
public class springConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());

    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
