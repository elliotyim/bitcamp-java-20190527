// 상속 문법을 이용하여 스택 만들기
package com.eomcs.util;

public class Stack<E> extends LinkedList<E> implements Cloneable, Iterable<E> {
  public void push(E value) {
    add(value);
  }
  
  @Override
  public Stack<E> clone() throws CloneNotSupportedException {
    // 현재 스택 객체의 노드를 그대로 유지하기 위해 "deep copy"를 실행한다.
    // => 새 스택을 만들고,
    Stack<E> temp = new Stack<>();
    for (int i = 0; i < size(); i++) {
      // => 현재 스택에서 값을 꺼내 새 스택의 새 노드에 넣는다.
      //    즉 새 스택은 값을 넣을 때 마다 노드를 생성하기 때문에
      //    현재 스택의 노드에는 영향을 끼치지 않는다.
      temp.push(get(i));
    }
    return temp;

  }

  public E pop() {
    return remove(size()-1);
  }
  
  public boolean empty() {
    return size() == 0;
  }
  @Override
  public Iterator<E> iterator() {
    // 특정 메서드 안에서만 사용되는 클래스라면 메서드 안에 선언하라!
    // 이렇게 메서드 안에 선언된 중첩 클래스를 "local class"라 부른다.
    return new Iterator<E>() {
      
      @Override
      public boolean hasNext() {
        return size() > 0;
      }
      
      @Override
      public E next() {
        return pop();
      }
    };
  }
  
  
}
