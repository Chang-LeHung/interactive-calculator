package executor;

import bytecode.ByteCodeGenerator;
import objects.ICObject;
import parser.ExpressionParser;
import parser.Node;
import parser.ParseException;
import util.BuiltIn;
import util.DFS;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Terminal {

  public static void main(String[] args) throws ParseException, InterruptedException {
    Scanner scanner = new Scanner(System.in);
    ExpressionParser parser = new ExpressionParser( System.in ) ;
    ByteCodeGenerator generator = new ByteCodeGenerator();
    ByteCodeExecutor executor = new ByteCodeExecutor();
    DFS dfs = new DFS();
    while (true) {
      System.out.print(">");
      String line = scanner.nextLine();
      if (BuiltIn.isBuiltInCommand(line)) {
        BuiltIn.execute(line);
        continue;
      }
      try {
        if (BuiltIn.execSystemCommand(line))
          continue;
      } catch (Exception e) {
      }
      if (!line.equalsIgnoreCase("")) {
      if (!line.equalsIgnoreCase("dump")) {
        try {
          parser.ReInit(new ByteArrayInputStream(line.getBytes(StandardCharsets.UTF_8)));
          Node node = parser.expression();
          dfs.dumpAST(node);
          generator.cleanCodeContainer();
          generator.generateByteCode(node);
          ICObject run = executor.run(generator.getCodeContainer());
          if (null != run)
            System.out.println(run);
        }catch (Exception e) {
          System.err.println(e.getMessage());
          System.out.println();
        }catch (Error e) {
//          System.err.println(e);
//          System.out.println();
        }
      }else {
        System.out.println("digraph AST {");
        System.out.println(dfs.getNodes().toString());
        System.out.println(dfs.getEdges().toString());
        System.out.println("}");
        }
      }
    }
  }
}
