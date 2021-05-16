package com.hello.hellospring;


import com.hello.hellospring.repository.MemberRespository;
import com.hello.hellospring.repository.MemoryMemberRepository;
import com.hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRespository());
    }

    @Bean
    public MemberRespository memberRespository() {
        return new MemoryMemberRepository();
    }
}
