package hello.core.discount;

import hello.core.member.Gradle;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;
    // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        // 테스트 코드 자동 작성
        // 컨트롤 + 시프트 + T
       if (member.getGradle() == Gradle.VIP){
            return discountFixAmount;
       }else {
           return 0;
       }

    }
}
