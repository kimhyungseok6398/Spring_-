package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemoryMemberRepository;

public interface OrderService {
  Order createOrder(Long memberId, String itemName, int itemPrice);

    void setMemberRepository(MemoryMemberRepository memoryMemberRepository);

  void setDiscountPolicy(FixDiscountPolicy fixDiscountPolicy);
}
