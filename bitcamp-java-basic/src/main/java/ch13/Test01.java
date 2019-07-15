package ch13;

public class Test01 {

  public static void main(String[] args) {
    
    Score s1 = new Score();
    s1.setName("홍길동"); //여기서 넘긴 인스턴스 주소가 this로 넘어간다.
    s1.setKor(100);
    s1.setEng(90);
    s1.setMath(80);
    System.out.printf("%s: 총점=%d, 평균=%.1f\n", s1.getName(), s1.getSum(), s1.getAver());
  }

}






