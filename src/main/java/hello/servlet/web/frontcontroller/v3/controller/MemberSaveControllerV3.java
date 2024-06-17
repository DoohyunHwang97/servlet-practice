package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) throws ServletException, IOException {
        Member member = new Member(
                paramMap.get("username"),
                Integer.parseInt(paramMap.get("age"))
        );
        memberRepository.save(member);

        ModelView modelView = new ModelView("save-result");
        modelView.getModelMap().put("member", member);

        return modelView;
    }
}
