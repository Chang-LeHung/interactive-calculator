package util;

import java.util.HashSet;

public class BuiltIn {

  static HashSet<String> builtInCommands = new HashSet<>();

  static {
    builtInCommands.add("cls");
    builtInCommands.add("clear");
    builtInCommands.add("exit");
    builtInCommands.add("quit");
    builtInCommands.add("q");
  }

  public static boolean isBuiltInCommand(String commandName) {

    return builtInCommands.contains(commandName.toLowerCase());
  }

  public static void execute(String command) {
    if (!isBuiltInCommand(command))
      throw new RuntimeException(command + " is not a builtin command\n");
    switch (command) {
      case "cls":
      case "clear":
        doClear();
        break;
      case "quit":
      case "q":
      case "exit":
        doQuit();

    }
  }

  private static void doClear() {
    System.out.print("\033[H\033[2J\n");
    System.out.flush();
  }

  private static void doQuit() {
    System.exit(0);
  }

  public static void setBuiltInCommands(HashSet<String> builtInCommands) {
    BuiltIn.builtInCommands = builtInCommands;
  }

  public static void main(String[] args) {
    String name = "2";
    switch (name) {
      case "1":
        System.out.println("This is 1");
      case "2":
        System.out.println("This is 2");
      default:
        System.out.println("default");
    }
  }
}
