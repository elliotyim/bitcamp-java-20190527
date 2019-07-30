package ch22.f;

public class Test00 {
  static class Score1 {
    
  }
  static class Score2 {
    // 복제 기능을 수행하려면 clone()을 오버라이딩 해야 한다.
    @Override
    public Score2 clone() throws CloneNotSupportedException {
      return (Score2) super.clone();
    }
  }
  // 이 클래스는 복제 가능하다고 설정한다.
  static class Score3 implements Cloneable{
    
    // Cloneable 인터페이스에는 메서드가 없다.
    // 따라서 이 인터페이스를 구현하는 클래스는 메서드를 정의할 필요가 없다.
    // 이 인터페이스의 목적은 
    String name;
    @Override
    public Score2 clone() throws CloneNotSupportedException {
      return (Score2) super.clone();
    }
  }

  public static void main(String[] args) throws CloneNotSupportedException {
    Score1 obj1 = new Score1();
    //Score1 copy = obj1.clone(); //컴파일 오류!
    // Object 클래스에서 상속 받은 clone()은 기본적으로 protected 이다.
    // 따라서 외부에서 호출할 수 없다.
    
    Score2 obj2 = new Score2();
    Score2 copy2 = obj2.clone(); // 런타임(run-time) 오류!
    // Object에서 상속받은 clone()을 호출하려면
    // 해당 클래스에 대해 복제를 활성화해야 한다.
    // 방법? java.lang.Cloneable 인터페이스를 구현하라!
    
    Score3 obj3 = new Score3();
    obj3.name = "홍길동";
    
    
  }

}
