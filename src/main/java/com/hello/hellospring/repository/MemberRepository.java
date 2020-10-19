package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // 없으면 null 반환
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
