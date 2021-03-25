/* Copyright: https://raw.githubusercontent.com/namin/unsound/master/doc/unsound-oopsla16.pdf */
package unsound;

public class Unsound {

  public static void main(String[] args) {
    Animal animal1 = Unsound.<Monkey>coerceSimple(new Monkey());
    System.out.println(animal1);

    Animal animal2 = Unsound.<Animal, Monkey>coerce(new Monkey());
    System.out.println(animal2);

    Animal animal3 = Unsound.<Animal, Tree>coerce(new Tree());
    System.out.println(animal3);
  }

  static <ParentT, ChildT> ParentT coerce(ChildT childT) {
    Constrain<ParentT, ? super ChildT> constrain = null;
    Bind<ParentT> bind = new Bind<ParentT>();
    return bind.upcast(constrain, childT);
  }

  static <ChildT> Animal coerceSimple(ChildT monkey) {
    Constrain<Animal, ? super ChildT> constrain = null;
    Bind<Animal> bind = new Bind<Animal>();
    return bind.upcast(constrain, monkey);
  }
}

/*===========================================================================*/
class Constrain<ParentT, ChildT extends ParentT> {

}

class Bind<ParentT> {

  <ChildT extends ParentT> ParentT upcast(Constrain<ParentT, ChildT> constrain, ChildT childT) {
    return childT;
  }
}

/*===========================================================================*/
class Animal {

  @Override
  public String toString() {
    return this.getClass().getSimpleName();
  }
}

class Monkey extends Animal {

}

class Human extends Animal {

}

/*===========================================================================*/
class Tree {

  @Override
  public String toString() {
    return this.getClass().getSimpleName();
  }
}
/*===========================================================================*/
