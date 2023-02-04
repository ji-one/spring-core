package hello.core.singleton;

public class StatefulService {

//    private int price; // 상태를 유지하는 필드

    public int order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; // 여기가 문제: price 필드는 공유되는 필드인데, 특장 클라이언트가 값을 변경한다.
        return price;
    }
//
//    public int getPrice(){
//        return price;
//    }

}
