package yangbum94.yangbum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yangbum94.yangbum.aop.TimeTraceAop;
import yangbum94.yangbum.repository.*;
import yangbum94.yangbum.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class springConfig {


    private final MemberRepository memberRepository;
    @Autowired
    public springConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
//    @Bean
//    public MemberRepository memberRepository(){

        //return new MemoryMemberRepository();
       // return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
 //    }

}
