package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {
  static Scanner keyScan;

  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in;
    keyScan = new Scanner(keyboard);
    
    Lesson3[] lessons = new Lesson3[100];
    
    int i = 0;
    for ( ; i<lessons.length; i++) {
      Lesson3 lesson = new Lesson3();
      lesson.no = getIntValue("번호? ");
      lesson.contents = getStringValue("내용? ");
      lesson.writtenDate = Date.valueOf("2019-01-01");
      lesson.view = 0;
      
      lessons[i] = lesson;
      
      System.out.print("계속 입력하시겠습니까? (Y/N)");
      String response = keyScan.nextLine();
      if (response.equalsIgnoreCase("N")) {
        break;
      }
    }
    
    System.out.println();
    
    for (int i2 = 0; i2 <= i; i2++) {
      Lesson3 lesson = lessons[i2];
      System.out.printf("%s, %s\t, %s, %s\n",
          lesson.no, lesson.contents, lesson.writtenDate, lesson.view);
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
