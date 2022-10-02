package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

public class BuiltIn {

  static HashSet<String> builtInCommands = new HashSet<>();

  static {
    builtInCommands.add("cls");
    builtInCommands.add("clear");
    builtInCommands.add("exit");
    builtInCommands.add("quit");
    builtInCommands.add("q");
    builtInCommands.add("h");
    builtInCommands.add("help");
  }

  public static boolean isBuiltInCommand(String commandName) {

    return builtInCommands.contains(commandName.toLowerCase());
  }

  public static boolean execSystemCommand(String command) throws IOException, InterruptedException {
    Process p = Runtime.getRuntime().exec(command);
    java.io.InputStream is = p.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8)); //设置读取的时候的编码为GBK
    p.waitFor();
    if(p.exitValue()!=0){
      return false;
    }else{
      String s;
      while((s = reader.readLine()) != null){
        System.out.println(s);
      }
    }
    return true;
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
      case "h":
      case "help":
        doHelp();

    }
  }

  private static void doHelp() {
    System.out.println("This software has following commands");
    System.out.println("`h` or `help` print the help information");
    System.out.println("`quit` or `q` or `exit` exit the software");
    System.out.println("`cls` or `clear` clear the screen");
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
