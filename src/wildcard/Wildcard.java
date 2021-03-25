package wildcard;

import java.util.ArrayList;
import java.util.List;

public class Wildcard {

  public void test() {
    List<Object> objects;
    objects = new ArrayList<>();
    objects = new ArrayList<String>();

    objects.add("");
    objects.add(1L);

    List<?> wildcard;
    wildcard = new ArrayList<>();
    wildcard = new ArrayList<ArrayList>();

    wildcard.add("");
    wildcard.add(1L);
  }

}
