package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.util.Input;

public class MemberHandler {
  private Member[] members = new Member[100];
  private int membersSize = 0;
  
  private Input input;
  
  public MemberHandler(Input input) {
    this.input = input;
  }
  
  public void addMember() {
    Member member = new Member();
    member.no = input.getIntValue("번호? ");
    member.name = input.getStringValue("이름? ");
    member.email = input.getStringValue("이메일? ");
    member.password = input.getIntValue("암호? ");
    member.photo = input.getStringValue("사진? ");
    member.phoneNum = input.getStringValue("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());
    
    members[membersSize++] = member;
  }
  
  public void listMember() {
    for (int i = 0; i < membersSize; i++) {
      Member member = members[i];
      System.out.printf("%s, %s , %s\t, %s\t, %s\n",
          member.no, member.name, member.email, member.phoneNum, member.registeredDate);
    }
  }
}
