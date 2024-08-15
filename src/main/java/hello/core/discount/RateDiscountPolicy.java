package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Gradle;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
    if(member.getGradle() == Gradle.VIP){
        return price * discountPercent /100;
    }else {
        return 0;
    }   // 단축키 컨트롤 + 시프트 + T
    }

    @Override
    public int discount(Member member, int i, String fixDiscountPolicy) {
        return 0;
    }
}
