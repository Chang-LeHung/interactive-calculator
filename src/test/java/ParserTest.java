import bytecode.ByteCodeGenerator;
import executor.ByteCodeExecutor;
import objects.ICObject;
import org.junit.Test;
import parser.ExpressionParser;
import parser.Node;
import parser.ParseException;
import util.DFS;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class ParserTest {

  @Test
  public void parserTest() throws ParseException {
    Scanner scanner = new Scanner(System.in);
    ExpressionParser parser = new ExpressionParser( System.in ) ;
    DFS dfs = new DFS();
    ByteCodeGenerator generator = new ByteCodeGenerator();
    ByteCodeExecutor executor = new ByteCodeExecutor();
    System.out.println("start");
    ArrayList<String> list = new ArrayList<>();
//    list.add("1+2+3;");
//    list.add("a=1+2+4*8 - 2 + 5");
    list.add("a=1");
    list.add("a");
    list.add("l");
    list.add("1+2+4*2-5+6*3/2*4/2");
    for (String s : list) {
      parser.ReInit(new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8)));
      Node node = parser.expression();
      dfs.dumpAST(node);
//      System.out.println(dfs.getNodes().toString());
//      System.out.println(dfs.getEdges().toString());
      generator.cleanCodeContainer();
      generator.generateByteCode(node);
      ICObject run = executor.run(generator.getCodeContainer());
      System.out.println("run = " + run);
    }
  }
}
