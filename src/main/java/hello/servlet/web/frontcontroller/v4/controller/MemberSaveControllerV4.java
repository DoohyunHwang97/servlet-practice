package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model)
            throws ServletException, IOException {
        Member member = new Member(
                paramMap.get("username"),
                Integer.parseInt(paramMap.get("age"))
        );
        memberRepository.save(member);

        model.put("member", member);

        return "save-result";
    }
}
