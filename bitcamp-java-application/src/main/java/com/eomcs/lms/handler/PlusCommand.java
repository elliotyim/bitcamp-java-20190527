package com.eomcs.lms.handler;

import com.eomcs.util.Input;

public class PlusCommand implements Command {
  Input input;
  
  public PlusCommand(Input input) {
    this.input = input;
  }
  
  @Override
  public void execute() {
    int value1 = input.getIntValue("값1? ");
    int value2 = input.getIntValue("값2? ");
    System.out.println("합계는 " + (value1+value2) + " 입니다.");
  }

}
