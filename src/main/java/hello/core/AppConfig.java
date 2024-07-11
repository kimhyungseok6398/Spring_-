package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }   // 생성자를 만들어서 new MemoryMemberRepository에 대한 참조값을
        // MemberServiceImpl에 생성자로 넣어준다.
    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

    // 단축키 컨트롤 + E 과거 히스토리 목록이 나온다.
}
    //설계변경으로 MemberServiceImpl는 인터페이스만을 의존한다
    // MemberServiceImpl 의 생성자를 통해 어떤 구현 객체를 주입 할지는 오직 외부 (AppConfig)에 의해 결정 된다.
    //
