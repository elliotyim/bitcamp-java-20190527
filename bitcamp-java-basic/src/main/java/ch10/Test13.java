// 초기화 블록 - 클래스 로딩과 스태틱 블록 실행 과정
package ch10;

class A {
  static int a = 7;
  
  static {
    System.out.println("A.static{}");
    //여기서는 클래스 로딩이 메소드 안에 메소드를 실행하듯이 안으로 들어가는 방식으로 쌓이면서 안으로 들어갔다가 나온다.
    a += B.b; // 1) 처음에 여기서 연산을 수행하기 전에 B클래스가 로딩되어야 하므로 잠시 멈추고 B 클래스를 로딩한다.
              // 3) B클래스의 로딩이 완료 되었으므로 7+=29를 실행함 (a=32)
  }
}

class B {
  static int b = 22;
  
  static {
    System.out.println("B.static{}");
    b += A.a; // 2) 22+=7 을 실행함 (b=29)
  }
}

public class Test13 {
  public static void main(String[] args) {
    System.out.println(A.a); // ?
    System.out.println(B.b); // ? 
    
    // 클래스 로딩 절차
    // 1) 클래스를 Method Area에 로딩한다.
    // 2) 스태틱 변수를 만든다.
    // 3) 스태틱 블록을 실행한다.
    //
    
    // 클래스 로딩
    // => 클래스 멤버(변수, 메서드)를 사용할 때
    // => Class.forName("클래스명") 을 통해 임의로 로딩할 때
    // => 단 한 번 로딩된 클래스는 다시 로딩하지 않는다.
    //
    
    // 스태틱 블록의 목적
    // => 클래스 멤버(스태틱 변수, 스태틱 메서드)를 사용하기 전에 유효한 값으로 초기화 시키는 것이다.
  }
}
















