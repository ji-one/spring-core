package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instnace = new SingletonService();

    // 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService() {
    }

    public static SingletonService getInstance() {
        return instnace;
    }

    public void logic() {
        System.out.println("싱글톤 객체 로   직 호출");
    }
}
