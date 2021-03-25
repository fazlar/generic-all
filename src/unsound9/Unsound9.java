/* Copyright: https://raw.githubusercontent.com/namin/unsound/master/doc/unsound-oopsla16.pdf */
package unsound9;

class Unsound9 {
  static class Type<A> {
    class Constraint<B extends A> extends Type<B> {
    }

    <B> Constraint<? super B> bad() {
      return null;
    }

    <B> A coerce(B b) {
      return pair(this.<B>bad(), b).value;
    }
  }

  static class Sum<T> {
    Type<T> type;
    T value;

    Sum(Type<T> t, T v) {
      type = t;
      value = v;
    }
  }

  static <T> Sum<T> pair(Type<T> type, T value) {
    return new Sum<T>(type, value);
  }

  static <T, U> U coerce(T t) {
    Type<U> type = new Type<U>();
    return type.<T>coerce(t);
  }

  public static void main(String[] args) {
    String zero = Unsound9.<Integer, String>coerce(0);
  }
}