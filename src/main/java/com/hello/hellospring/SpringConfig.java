package com.hello.hellospring;


import com.hello.hellospring.repository.MemberRespository;
import com.hello.hellospring.repository.MemoryMemberRepository;
import com.hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRespository memberRespository;

    @Autowired
    public SpringConfig(MemberRespository memberRespository) {
        this.memberRespository = memberRespository;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRespository());
    }

    @Bean
    public MemberRespository memberRespository() {
        return new MemoryMemberRepository();
    }
}
