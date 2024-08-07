package hello.core.singleton;

public class SingletonService {

    private static final SingletonService Instance = new SingletonService();

    public static SingletonService getInstance(){
        return Instance;
        // 자바가 실행될때 싱글톤에 new 본인객체를 생성해서 인스턴스 변수에 대입

    }

    private SingletonService(){

    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
