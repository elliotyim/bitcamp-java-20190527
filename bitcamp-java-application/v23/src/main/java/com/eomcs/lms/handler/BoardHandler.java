package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Input;
import com.eomcs.util.LinkedList;
import com.eomcs.util.List;

public class BoardHandler {
  
  private List<Board> boardList;
  private Input input;
  
  // BoardHandler가 사용하는 Input 객체를 반드시 설정하도록 강제해보자!
  // => Input 객체처럼 어떤 작업을 실행하기 위해 반드시 있어야 하는 객체를
  //    "의존 객체(dependency)"라 부른다.
  // => 의존 객체를 강제로 설정하게 만드는 방법?
  //    다음과 같이 의존 객체를 넘겨받는 생성자를 정의하는 것이다.
  public BoardHandler (Input input, List<Board> list) {
    this.input = input;
    this.boardList = list;
  }
  
  public void addBoard() {
    Board board = new Board();
    board.setNo(input.getIntValue("번호? "));
    board.setContents(input.getStringValue("내용? "));
    board.setCreatedDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);
    
    boardList.add(board);
    
    System.out.println("저장하였습니다.");
  }
  
  public void listBoard() {
    //Board[] boards = new Board[boardList.size()];
    //boardList.toArraylist(boards);
    
    Board[] boards = boardList.toArray(new Board[] {}); // 복사할려는 배열을 사이즈가 0인 빈 배열을 주면
                                                        // 자동으로 내부적으로 새 배열을 만들기 때문에 이렇게도 씀
    for (Board board : boards) {
      System.out.printf("%s, %s\t, %s, %s\n",
          board.getNo(), board.getContents(),
          board.getCreatedDate(), board.getViewCount());
    }
  }

  public void detailBoard() {
    int no = input.getIntValue("번호? ");
    
    Board board = null;
    for (int i = 0; i<boardList.size(); i++) {
      if (no == boardList.get(i).getNo()) {
        board = boardList.get(i);
      }
    }
    
    if (board == null) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }
    
    System.out.println("내용: " + board.getContents());
    System.out.println("작성일: " + board.getCreatedDate());
    
  }

  public void updateBoard() {
    int no = input.getIntValue("번호? ");
    
    Board board = null;
    for (int i = 0; i<boardList.size(); i++) {
      if (no == boardList.get(i).getNo()) {
        board = boardList.get(i);
      }
    }
    
    if (board == null) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }
    
    String str = input.getStringValue("내용? ");
    
    if (str.length()>0) {
      board.setContents(str);
    }
    
    System.out.println("게시글을 변경했습니다.");
    
  }

  public void deleteBoard() {
    int no = input.getIntValue("번호? ");
    
    Board board = null;
    for (int i = 0; i<boardList.size(); i++) {
      if (no == boardList.get(i).getNo()) {
        boardList.remove(i);
        System.out.println("게시글을 삭제했습니다.");
        return;
      }
    }
    
    if (board == null) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }
    
  }
}
