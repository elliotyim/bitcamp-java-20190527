package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {
  static Scanner keyScan;

  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in;
    keyScan = new Scanner(keyboard);
    
    Board[] boards = new Board[100];
    
    int i = 0;
    for ( ; i<boards.length; i++) {
      Board board = new Board();
      board.no = getIntValue("번호? ");
      board.contents = getStringValue("내용? ");
      board.writtenDate = Date.valueOf("2019-01-01");
      board.view = 0;
      
      boards[i] = board;
      
      System.out.print("계속 입력하시겠습니까? (Y/N)");
      String response = keyScan.nextLine();
      if (response.equalsIgnoreCase("N")) {
        break;
      }
    }
    
    System.out.println();
    
    for (int i2 = 0; i2 <= i; i2++) {
      Board board = boards[i2];
      System.out.printf("%s, %s\t, %s, %s\n",
          board.no, board.contents, board.writtenDate, board.view);
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
