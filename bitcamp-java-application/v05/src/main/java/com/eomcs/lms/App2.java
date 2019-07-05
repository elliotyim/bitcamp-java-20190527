package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  static Scanner keyScan;
  
  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in;
    keyScan = new Scanner(keyboard);
    
    int no = getIntValue("번호? ");
    String name = getStringValue("이름? ");
    String email = getStringValue("이메일? ");
    int password = getIntValue("암호? ");
    String photo = getStringValue("사진? ");
    String phoneNum = getStringValue("전화? ");
    Date signUpDate = getDateValue("가입일? ");
    
    System.out.println();
    
    System.out.println("번호: " + no);
    System.out.println("이름: " + name);
    System.out.println("이메일: " + email);
    System.out.println("암호: " + password);
    System.out.println("사진: " + photo);
    System.out.println("전화: " + phoneNum);
    System.out.println("가입일: " + signUpDate);
  }
  
  private static int getIntValue(String message) {
    while (true) {
      try {
        System.out.println(message);
        return Integer.parseInt(keyScan.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("잘못된 숫자입니다.");
      }
    }
  }
  
  private static String getStringValue(String message) {
    System.out.println(message);
    return keyScan.nextLine();
  }
  
  private static Date getDateValue(String message) {
    while (true) {
      try {
        System.out.println(message);
        return Date.valueOf(keyScan.nextLine());
      } catch (IllegalArgumentException e) {
        System.out.println("2019-07-05의 형태로 입력해주세요.");
      }
    }
  }
  
}
