package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  static Scanner keyScan;
  
  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in;
    keyScan = new Scanner(keyboard);
    
    Lesson2[] lessons = new Lesson2[100];
    
    int i = 0;
    for ( ; i<lessons.length; i++) {
      Lesson2 lesson = new Lesson2();
      lesson.no = getIntValue("번호? ");
      lesson.name = getStringValue("이름? ");
      lesson.email = getStringValue("이메일? ");
      lesson.password = getIntValue("암호? ");
      lesson.photo = getStringValue("사진? ");
      lesson.phoneNum = getStringValue("전화? ");
      lesson.signUpDate = Date.valueOf("2019-01-01");
      
      lessons[i] = lesson;
      
      System.out.print("계속 입력하시겠습니까? (Y/N)");
      String response = keyScan.nextLine();
      if (response.equalsIgnoreCase("N")) {
        break;
      }
    }
    
    System.out.println();
    
    for (int i2 = 0; i2 <= i; i2++) {
      Lesson2 lesson = lessons[i2];
      System.out.printf("%s, %s , %s\t, %s\t, %s\n",
          lesson.no, lesson.name, lesson.email, lesson.phoneNum, lesson.signUpDate);
    }
    
  }
  
  private static int getIntValue(String message) {
    while (true) {
      try {
        System.out.print(message);
        return Integer.parseInt(keyScan.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("잘못된 숫자입니다.");
      }
    }
  }
  
  private static String getStringValue(String message) {
    System.out.print(message);
    return keyScan.nextLine();
  }
}
