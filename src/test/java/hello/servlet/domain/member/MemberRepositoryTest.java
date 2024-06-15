package hello.servlet.domain.member;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member("hello", 20);

        memberRepository.save(member);

        assertThat(memberRepository.findById(member.getId())).isSameAs(member);
    }

    @Test
    void findAll() {
        Member member1 = new Member("hello1", 20);
        Member member2 = new Member("hello2", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> members = memberRepository.findAll();

        assertThat(members.size()).isEqualTo(2);
        assertThat(members).contains(member1, member2);
    }
}