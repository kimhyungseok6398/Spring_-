package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.jar.JarOutputStream;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            //iter + tap 를 하면 자동으로 for문을 만들어준다.
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + "beanDefinitionName" + "Object =" + bean);

            //soutv 는 변수명으로 담아주고
            //soutm은 메서드명으로 담아준다
        }
        }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            //iter를 하면 자동으로 for문을 만들어준다.
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            //soutv 는 변수명으로 담아주고
            //sourm은 메서드명으로 담아준다
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
        // 애플리케이션을 개발하기위한 빈들
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + "beanDefinitionName" + "Object =" + bean);

            }
        }
    }
    }

