package com.eomcs.lms.handler;

import java.util.List;

import com.eomcs.lms.domain.Member;
import com.eomcs.util.Input;

public class MemberDetailCommand implements Command{
  private List<Member> list;
  private Input input;
  
  public MemberDetailCommand(Input input, List<Member> list) {
    this.input = input;
    this.list = list;
  }
  
  @Override
  public void execute() {
    int no = input.getIntValue("번호? ");
    
    Member member = null;
    for (int i = 0; i<list.size(); i++) {
      if (no == list.get(i).getNo()) {
        member = list.get(i);
      }
    }
    
    if (member == null) {
      System.out.println("해당 회원을 찾을 수 없습니다.");
      return;
    }
    
    System.out.println("이름: " + member.getName());
    System.out.println("이메일: " + member.getEmail());
    System.out.println("암호: " + member.getPassword());
    System.out.println("사진: " + member.getPhoto());
    System.out.println("전화: " + member.getPhoneNum());
    System.out.println("가입일: " + member.getRegisteredDate());
  }
}
