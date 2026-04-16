package chapter07;

import java.io.Serializable;

class Department implements Serializable {
  private static final long serialVersionUID = 1L;

  String name;
  Employee leader;
}
