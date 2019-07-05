package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {
  static Scanner keyScan;

  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in;
    keyScan = new Scanner(keyboard);
    
    int[] no = new int[100];
    String[] content = new String[100];
    Date[] writtenDate = new Date[100];
    int[] view = new int[100];
    
    int i = 0;
    for ( ; i<no.length; i++) {
      no[i] = getIntValue("번호? ");
      content[i] = getStringValue("내용? ");
      writtenDate[i] = Date.valueOf("2019-01-01");
      view[i] = 0;
      
      System.out.print("계속 입력하시겠습니까? (Y/N)");
      String response = keyScan.nextLine();
      if (response.equalsIgnoreCase("N")) {
        break;
      }
    }
    
    System.out.println();
    
    for (int i2 = 0; i2 <= i; i2++) {
        System.out.printf("%s, %s\t, %s, %s\n",
            no[i2], content[i2], writtenDate[i2], view[i2]);
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
