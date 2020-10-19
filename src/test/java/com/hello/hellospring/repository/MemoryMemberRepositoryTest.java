package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // test 실행 순서는 random -> test 후 data clear
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("jimin");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

//        Assertions.assertEquals(member, result);
//        Assertions.assertThat(member).isEqualTo(result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("jk");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("v");
        repository.save(member2);

        Member result = repository.findByName("jk").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("jk");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("v");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
