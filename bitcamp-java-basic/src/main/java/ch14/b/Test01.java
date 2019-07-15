// 오버라이딩과 this/super
package ch14.b;

public class Test01 {

  public static void main(String[] args) {
    X2 obj = new X2(); //자동차에 자동차를 집어넣는다.
    obj.test();
    
    System.out.println("--------------------------------");
    
    obj = new X3(); // 자동차에 티코를 집어넣는다.
    obj.test();  // super.m1()에서의 super는 해당 클래스의 super이지 전달받은 객체주소의 super가 아니다.
                 // 그래서 X3.m1()이 호출 된 후 X1.m1()이 호출 된것.
    System.out.println("--------------------------------");
    
    X3 obj2 = new X3(); // 자동차에 티코를 집어넣는다.
    obj2.test();
    
    System.out.println("--------------------------------");
    
    X4 obj3 = new X4();
    obj3.test();
    
    System.out.println("--------------------------------");
    
    X5 obj4 = new X5();
    obj4.test();
  }
  
}
