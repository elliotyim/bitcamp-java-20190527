package com.eomcs.lms.handler;

import java.util.List;

import com.eomcs.lms.domain.Member;
import com.eomcs.util.Input;

public class MemberUpdateCommand implements Command{
  private List<Member> list;
  private Input input;
  
  public MemberUpdateCommand(Input input, List<Member> list) {
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
}
