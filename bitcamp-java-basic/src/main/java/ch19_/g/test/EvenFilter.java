package ch19_.g.test;

public class EvenFilter implements Filter {

  @Override
  public boolean accept(int value) {
    return (value % 2) == 0;
  }

}
