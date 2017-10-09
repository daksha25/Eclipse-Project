package com.cognizant;

public class Program {
  String message = "foo";

  public String foo() {
    return message;
  }

  public void uncoveredMethod() {
    System.out.println(foo());
  }
}
