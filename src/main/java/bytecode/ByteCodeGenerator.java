package bytecode;

import parser.Node;
import util.DFS;

import java.util.ArrayList;

public class ByteCodeGenerator extends DFS {
  /**
   * bytecode definition
   *
   */

  private ArrayList<ByteCodeDefinition> codeContainer = new ArrayList<>();

  public void generateByteCode(Node node) {

    generateByteCode(node.getLeftChild());
    generateByteCode(node.getLeftChild());

    if (node.getNodeType() == Node.Type.IDENTIFIER) {

    }
  }

  public static void main(String[] args) {
    System.out.println("Hello world");
  }
}
