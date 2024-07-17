package hello.core;

import hello.core.member.Gradle;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //MemberService memberService = new MemberServiceImpl();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        //스프링 컨테이너를 통해 찾아온다.
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
