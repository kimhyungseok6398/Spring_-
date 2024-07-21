package hello.core.beanfind;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBeanFIndTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은타입이 둘 이상 있으면, 중복 오류가 발생한다")
    void findBeanByTypeDuplicate(){
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean(MemberRepository.class));
    }
    @Test
    @DisplayName("타입으로 조회시 같은타입이 둘 이상 있으면, 빈이름을 지정하면 된다")
    void findBeanByName(){
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanType(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
           System.out.println("key = " + key + "value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(1);
        // 추후 확인 테스트 에러뜨는 부분 빈 갯수? 확인
    }

    @Configuration // 스타틱을 썻기 때문에 안에서만 쓴다는 얘기
    static class SameBeanConfig {

        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
