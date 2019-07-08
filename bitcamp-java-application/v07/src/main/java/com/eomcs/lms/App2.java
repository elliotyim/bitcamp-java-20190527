package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  static Scanner keyScan;
  
  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in;
    keyScan = new Scanner(keyboard);
    
    Member[] members = new Member[100];
    
    int i = 0;
    for ( ; i<members.length; i++) {
      Member member = new Member();
      member.no = getIntValue("번호? ");
      member.name = getStringValue("이름? ");
      member.email = getStringValue("이메일? ");
      member.password = getIntValue("암호? ");
      member.photo = getStringValue("사진? ");
      member.phoneNum = getStringValue("전화? ");
      member.registeredDate = Date.valueOf("2019-01-01");
      
      members[i] = member;
      
      System.out.print("계속 입력하시겠습니까? (Y/N)");
      String response = keyScan.nextLine();
      if (response.equalsIgnoreCase("N")) {
        break;
      }
    }
    
    System.out.println();
    
    for (int i2 = 0; i2 <= i; i2++) {
      Member member = members[i2];
      System.out.printf("%s, %s , %s\t, %s\t, %s\n",
          member.no, member.name, member.email, member.phoneNum, member.registeredDate);
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
