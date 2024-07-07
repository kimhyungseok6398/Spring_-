package hello.core;

import hello.core.member.Gradle;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Gradle.VIP);
        // 단축키 컨트롤 + alt + v  = 자동 변수 설정

        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        //
        System.out.println("new member =" + member.getName());
        System.out.println("find Member = " + findMember.getName());
        // 이렇게 확인하는 방식은 좋지 않다
        // 테스트 코드를 작성하여 학인하는것이 더 좋은 방식

    }
}
