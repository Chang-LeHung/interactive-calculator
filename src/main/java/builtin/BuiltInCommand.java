package builtin;

import java.util.HashSet;

public class BuiltInCommand {

  private static HashSet<String> builtInCommand = new HashSet<>();

  static {
    builtInCommand.add("pi");
    builtInCommand.add("e");
    builtInCommand.add("l");
  }

  public static boolean isBuiltInCommand(String name) {
    return builtInCommand.contains(name);
  }
}
