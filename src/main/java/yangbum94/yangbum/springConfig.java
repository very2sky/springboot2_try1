package yangbum94.yangbum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yangbum94.yangbum.repository.JdbcMemberRepository;
import yangbum94.yangbum.repository.JdbcTemplateMemberRepository;
import yangbum94.yangbum.repository.MemberRepository;
import yangbum94.yangbum.repository.MemoryMemberRepository;
import yangbum94.yangbum.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class springConfig {

    private DataSource dataSource;

    @Autowired
    public springConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());

    }
    @Bean
    public MemberRepository memberRepository(){

        //return new MemoryMemberRepository();
       // return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
