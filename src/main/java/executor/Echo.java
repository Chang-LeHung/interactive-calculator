package executor;

import java.io.IOException;
import java.util.Scanner;

public class Echo {


  public static void main(String[] args) throws IOException, InterruptedException {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print(">");
      String line = scanner.nextLine();
      if (line.equalsIgnoreCase("clear") || line.equalsIgnoreCase("cls")) {
        System.out.print("\033[H\033[2J\n");
        System.out.flush();
      }else if (line.equalsIgnoreCase("exit") || line.equalsIgnoreCase("q")
          || line.equalsIgnoreCase("quit"))
        System.exit(0);
      else
        if (!line.equalsIgnoreCase("")) {
          System.out.println("\"" + line + "\"");
        }else{
          System.out.println("equal empty");
        }
    }
  }

}
