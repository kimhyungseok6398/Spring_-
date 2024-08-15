package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration  // 설정정보
@ComponentScan  (   // 스프링 빈을 끌어올리기 위함
        //basePackages = "hello.core.member",// 하위패키지로만 찾아간다.
        //basePackageClasses = AutoAppConfig.class,// 본인패키지 포함 찾는다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class) // 컴포넌트 스캔에서 제외할것을 설정
)
public class AutoAppConfig {

    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
