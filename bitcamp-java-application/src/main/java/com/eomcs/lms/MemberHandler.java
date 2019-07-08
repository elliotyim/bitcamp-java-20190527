package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class MemberHandler {
  static Member[] members = new Member[100];
  static int membersSize = 0;
  static Scanner keyScan;
  
  static void addMember() {
    Member member = new Member();
    member.no = Input.getIntValue("번호? ");
    member.name = Input.getStringValue("이름? ");
    member.email = Input.getStringValue("이메일? ");
    member.password = Input.getIntValue("암호? ");
    member.photo = Input.getStringValue("사진? ");
    member.phoneNum = Input.getStringValue("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());
    
    members[membersSize++] = member;
  }
  
  static void listMember() {
    for (int i = 0; i < membersSize; i++) {
      Member member = members[i];
      System.out.printf("%s, %s , %s\t, %s\t, %s\n",
          member.no, member.name, member.email, member.phoneNum, member.registeredDate);
    }
  }
}
