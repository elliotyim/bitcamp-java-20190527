package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Input;
import com.eomcs.util.LinkedList;

public class MemberHandler {
  private LinkedList<Member> memberList = new LinkedList<>();
  private Input input;
  
  public MemberHandler(Input input) {
    this.input = input;
  }
  
  public void addMember() {
    Member member = new Member();
    member.setNo(input.getIntValue("번호? "));
    member.setName(input.getStringValue("이름? "));
    member.setEmail(input.getStringValue("이메일? "));
    member.setPassword(input.getIntValue("암호? "));
    member.setPhoto(input.getStringValue("사진? "));
    member.setPhoneNum(input.getStringValue("전화? "));
    member.setRegisteredDate(new Date(System.currentTimeMillis()));
    
    memberList.add(member);
  }
  
  public void listMember() {
    Member[] members = memberList.toArray(new Member[] {});
    for (Member member : members) {
      System.out.printf("%s, %s , %s\t, %s\t, %s\n",
          member.getNo(), member.getName(), member.getEmail(), member.getPhoneNum(),
          member.getRegisteredDate());
    }
  }

  public void detailMember() {
    int no = input.getIntValue("번호? ");
    
    Member member = null;
    for (int i = 0; i<memberList.size(); i++) {
      if (no == memberList.get(i).getNo()) {
        member = memberList.get(i);
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
  
  public void updateMember() {
    int no = input.getIntValue("번호? ");
    
    Member member = null;
    for (int i = 0; i<memberList.size(); i++) {
      if (no == memberList.get(i).getNo()) {
        member = memberList.get(i);
      }
    }
    
    if (member == null) {
      System.out.println("해당 회원을 찾을 수 없습니다.");
      return;
    }
    
    String str = input.getStringValue("이름(" + member.getName() + ")? ");
    if (str.length()>0) {
      member.setName(str);
    }
    
    str = input.getStringValue("이메일(" + member.getEmail()+ ")? ");
    if (str.length()>0) {
      member.setEmail(str);
    }
    
    member.setPassword(input.getIntValue("암호(" + member.getPassword()+ ")? "));
    
    
    str = input.getStringValue("사진(" + member.getPhoto()+ ")? ");
    if (str.length()>0) {
      member.setPhoto(str);
    }
    
    str = input.getStringValue("전화(" + member.getPhoneNum()+ ")? ");
    if (str.length()>0) {
      member.setPhoneNum(str);
    }
    
  }

  public void deleteMember() {
    int no = input.getIntValue("번호? ");
    
    Member member = null;
    for (int i = 0; i<memberList.size(); i++) {
      if (no == memberList.get(i).getNo()) {
        memberList.remove(i);
        System.out.println("해당 회원을 삭제했습니다.");
        return;
      }
    }
    
    if (member == null) {
      System.out.println("해당 회원을 찾을 수 없습니다.");
      return;
    }
    
  }
}
