/* Copyright: https://raw.githubusercontent.com/namin/unsound/master/doc/unsound-oopsla16.pdf */
package nullless;

class Nullless<T, U> {
  class Constrain<B extends U> {
  }

  Constrain<? super T> constrain;
  final U u;

  Nullless(T t) {
    u = coerce(t);
  }

  <B extends U>
  U upcast(Constrain<B> constrain, B b) {
    return b;
  }

  U coerce(T t) {
    return upcast(constrain, t);
  }

  public static void main(String[] args) {
    String zero = new Nullless<Integer, String>(0).u;
  }
}