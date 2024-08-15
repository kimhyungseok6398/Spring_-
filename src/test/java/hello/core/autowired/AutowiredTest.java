package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }
    static class TestBean{
         @Autowired(required = false)
        public void setNoBean(Member noBean1){
             System.out.println("noBean1 = " + noBean1);
         }
        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }   // 호출은 되지만 널로 들어온다.
        public void setNoBean3(Optional<Member>  noBean3){
            System.out.println("noBean3 = " + noBean3);
        } // 스프링 빈이 없으면 Optional.empty로 감싸준다
    }
}
