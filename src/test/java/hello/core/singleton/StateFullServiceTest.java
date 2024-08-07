package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


class StateFullServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFullService statefulService1 = ac.getBean(StateFullService.class);
        StateFullService statefulService2 = ac.getBean(StateFullService.class);

        //ThreadA : A 사용자가 10000원 주문
        int userAprice = statefulService1.order("userA", 10000);
        //ThreadA : B 사용자가 20000원 주문
        int userBprice = statefulService2.order("userB", 20000);

        // Thread : 사용자A 주문 금액 조 회
        //  int price = statefulService1.getPrice();
        System.out.println("price = " + userAprice);


        //Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    static class TestConfig{
        @Bean
        public StateFullService stateFullService(){
            return new StateFullService();
        }
    }

}