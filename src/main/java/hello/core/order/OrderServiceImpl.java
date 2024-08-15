package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
// 파라미터 있는 생성자 자동 생성
public class OrderServiceImpl implements OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

   private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    private DiscountPolicy rateDiscountPolicy;
    // 이런식으로 인터페이스만 의존하도록 설계
    // DIP를 지키면서 설계!!

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy){
//        this.discountPolicy = discountPolicy;
//    }
//    @Autowired //스프링이 생성시 자동으로 주입해주는역할

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy
    DiscountPolicy rateDiscountPolicy) {
       this.memberRepository = memberRepository;
       this.discountPolicy = rateDiscountPolicy;
    }   // 일반 메서드 주입 (거의 사용하지 않는다)


//    @Autowired
//    public void init(MemberRepository memberRepository,DiscountPolicy discountPolicy){
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }   // 일반 메서드 주입 ( 거의 사용하지 않는다 )



//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//    public void setDiscountPolicy(DiscountPolicy discountPolicy){
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        // 컨트롤 + alt + v
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice,discountPrice);

    }

    @Override
    public void setMemberRepository(MemoryMemberRepository memoryMemberRepository) {

    }

    @Override
    public void setDiscountPolicy(FixDiscountPolicy fixDiscountPolicy) {

    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
