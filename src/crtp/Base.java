package crtp;

public abstract class Base<T extends Base<T>> implements Comparable<T> {

  public abstract T returnT();

  @Override
  public int compareTo(T o) {
    return 0;
  }

  public Base returnBase() {
    return this;
  }

  public Base<T> returnBaseT() {
    return this;
  }

  public void parameters(T t, Base base, Base<T> baseT) {
    t.compareTo(t);
    t.compareTo(base);
    t.compareTo(baseT);

    base.compareTo(t);
    base.compareTo(base);
    base.compareTo(baseT);

    baseT.compareTo(t);
    baseT.compareTo(base);
    baseT.compareTo(baseT);
  }

  public void assignments(T t, Base base, Base<T> baseT) {
    t = t;
    t = base;
    t = baseT;

    base = t;
    base = base;
    base = baseT;

    baseT = t;
    baseT = base;
    baseT = baseT;
  }

}

class Self extends Base<Self> {

  @Override
  public Self returnT() {
    return this;
  }

}

class OtherSelf extends Base<Self> {

  @Override
  public Self returnT() {
    return new Self();
  }

}
