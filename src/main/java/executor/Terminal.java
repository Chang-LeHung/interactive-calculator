package executor;

import util.BuiltIn;

import java.util.Scanner;

public class Terminal {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print(">");
      String line = scanner.nextLine();
      if (BuiltIn.isBuiltInCommand(line)) {
        BuiltIn.execute(line);
      }else {
        if (!line.equalsIgnoreCase("")) {
          System.out.println(line);
        }
      }
    }
  }
}
