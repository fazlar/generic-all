package pecs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Producer extends, Consumer super
 */
public class PecsTest {

  @Test
  public void test_wild_card() {
    List<?> list1 = new ArrayList<?>();
    List<?> list2 = new ArrayList<Objects>();
    List<Object> list3 = new ArrayList<?>();
    List<Object> list4 = new ArrayList<Object>();
  }

  @Test
  public void test_extends_assignments() {
    List<? extends Grandpa> extendsGrandpa = new ArrayList<>();
    extendsGrandpa = new ArrayList<Grandpa>();
    extendsGrandpa = new ArrayList<Father>();
    extendsGrandpa = new ArrayList<Son>();

    List<? extends Father> extendsFather = new ArrayList<>();
    extendsFather = new ArrayList<Grandpa>();
    extendsFather = new ArrayList<Father>();
    extendsFather = new ArrayList<Son>();

    List<? extends Son> extendsSon = new ArrayList<>();
    extendsSon = new ArrayList<Grandpa>();
    extendsSon = new ArrayList<Father>();
    extendsSon = new ArrayList<Son>();
  }

  @Test
  public void test_super_assignments() {
    List<? super Grandpa> superGrandpa = new ArrayList<>();
    superGrandpa = new ArrayList<Grandpa>();
    superGrandpa = new ArrayList<Father>();
    superGrandpa = new ArrayList<Son>();

    List<? super Father> superFather = new ArrayList<>();
    superFather = new ArrayList<Grandpa>();
    superFather = new ArrayList<Father>();
    superFather = new ArrayList<Son>();

    List<? super Son> superSon = new ArrayList<>();
    superSon = new ArrayList<Grandpa>();
    superSon = new ArrayList<Father>();
    superSon = new ArrayList<Son>();
  }

  @Test
  public void test_super_consume() {
    List<? super Grandpa> superGrandpa = new ArrayList<>();
    superGrandpa.add(new Grandpa());
    superGrandpa.add(new Father());
    superGrandpa.add(new Son());


    List<? super Father> superFather = new ArrayList<>();
    superFather.add(new Grandpa());
    superFather.add(new Father());
    superFather.add(new Son());

    List<? super Son> superSon = new ArrayList<>();
    superSon.add(new Grandpa());
    superSon.add(new Father());
    superSon.add(new Son());
  }

  @Test
  public void test_super_produce() {
    List<? super Grandpa> superGrandpa = new ArrayList<>();
    Grandpa grandpaFromGrandpa = superGrandpa.get(0);
    Father fatherFromGrandpa = superGrandpa.get(0);
    Son sonFromGrandpa = superGrandpa.get(0);

    List<? super Father> superFather = new ArrayList<>();
    Grandpa grandpaFromFather = superFather.get(0);
    Father fatherFromFather = superFather.get(0);
    Son sonFromFather = superFather.get(0);

    List<? super Son> superSon = new ArrayList<>();
    Grandpa grandpaFromSon = superSon.get(0);
    Father fatherFromSon = superSon.get(0);
    Son sonFromSon = superSon.get(0);
  }

  @Test
  public void test_extends_consume() {
    List<? extends Grandpa> extendsGrandpa = new ArrayList<>();
    extendsGrandpa.add(new Grandpa());
    extendsGrandpa.add(new Father());
    extendsGrandpa.add(new Son());

    List<? extends Father> extendsFather = new ArrayList<>();
    extendsFather.add(new Grandpa());
    extendsFather.add(new Father());
    extendsFather.add(new Son());

    List<? extends Son> extendsSon = new ArrayList<>();
    extendsSon.add(new Grandpa());
    extendsSon.add(new Father());
    extendsSon.add(new Son());
  }

  @Test
  public void test_extends_produce() {
    List<? extends Grandpa> extendsGrandpa = new ArrayList<>();
    Grandpa grandpaFromGrandpa = extendsGrandpa.get(0);
    Father fatherFromGrandpa = extendsGrandpa.get(0);
    Son sonFromGrandpa = extendsGrandpa.get(0);

    List<? extends Father> extendsFather = new ArrayList<>();
    Grandpa grandpaFromFather = extendsFather.get(0);
    Father fatherFromFather = extendsFather.get(0);
    Son sonFromFather = extendsGrandpa.get(0);

    List<? extends Son> extendsSon = new ArrayList<>();
    Grandpa grandpaFromSon = extendsSon.get(0);
    Father fatherFromSon = extendsSon.get(0);
    Son sonFromSon = extendsSon.get(0);
  }
}

class Grandpa {
}

class Father extends Grandpa {
}

class Son extends Father {
}
