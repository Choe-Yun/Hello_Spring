package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemberRespository;
import com.hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {

    private final MemberRespository memberRespository;

    @Autowired
    public MemberService(MemberRespository memberRespository){
        this.memberRespository = memberRespository;
    }



    //회원가입
    public Long join(Member member) {
        Optional<Member> result = memberRespository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원");
        });

        validateDuplicateMember(member);

        memberRespository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRespository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRespository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRespository.findById(memberId);
    }

}
