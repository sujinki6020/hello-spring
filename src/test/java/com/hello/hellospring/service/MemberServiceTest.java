package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

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
        member2.setName("jhope");

        //when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//        assertThrows(NullPointerException.class, () -> memberService.join(member2));
        memberService.join(member2);
    }


    @Test
    void findMembers() {
        //given

        //when

        //then

    }

    @Test
    void findOne() {
        //given

        //when

        //then

    }
}