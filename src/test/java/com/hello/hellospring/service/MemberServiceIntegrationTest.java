package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("rm");

        //when
        Long savedId = memberService.join(member);

        //then
        Member foundMember = memberService.findOne(savedId).get();
        assertThat(member.getName()).isEqualTo(foundMember.getName());
    }

    @Test
    public void duplicateMemberException() {
        //given
        Member member1 = new Member();
        member1.setName("jhope");

        Member member2 = new Member();
        member2.setName("jk");

        //when
        memberService.join(member1);
//        assertThrows(IllegalStateException.class, () -> memberService.join(member1));
//        assertThrows(NullPointerException.class, () -> memberService.join(member2));
        memberService.join(member2);
    }
}