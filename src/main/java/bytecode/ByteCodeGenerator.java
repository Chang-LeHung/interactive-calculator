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

  public ByteCodeGenerator() {
  }

  public ArrayList<ByteCodeDefinition> getCodeContainer() {
    return codeContainer;
  }

  public void cleanCodeContainer() {
    codeContainer.clear();
  }

  public void generateByteCode(Node node) {

    if (node != null) {
      generateByteCode(node.getLeftChild());
      generateByteCode(node.getRightChild());

      switch (node.getNodeType()) {
        case IDENTIFIER:
          VariableDefinition variableDefinition = new VariableDefinition();
          variableDefinition.setName(node.getValue());
          if (node.getParent() == null || node.getParent().getRightChild()
            == node ||
                  node.getParent().getNodeType() != Node.Type.ASSIGN) {
            variableDefinition.setOpType(OPType.LOAD);
            codeContainer.add(variableDefinition);
          }
          break;
        case NUMBER:
          if (node.getValue().contains(".")) {
            DoubleDefinition doubleDefinition = new DoubleDefinition();
            doubleDefinition.setData(Double.parseDouble(node.getValue()));
            codeContainer.add(doubleDefinition);
          }else {
            IntegerDefinition doubleDefinition = new IntegerDefinition();
            doubleDefinition.setData(Integer.parseInt(node.getValue()));
            codeContainer.add(doubleDefinition);
          }
          break;
        case FUNCTION:
          FunctionDefinition functionDefinition = new FunctionDefinition();
          functionDefinition.setName(node.getValue());
          codeContainer.add(functionDefinition);
          break;
        case MINUS:
          MINUSDefinition minusDefinition = new MINUSDefinition();
          codeContainer.add(minusDefinition);
          break;
        case PLUS:
          PLUSDefinition plusDefinition = new PLUSDefinition();
          codeContainer.add(plusDefinition);
          break;
        case TIMES:
          TIMESDefinition timesDefinition = new TIMESDefinition();
          codeContainer.add(timesDefinition);
          break;
        case DIV:
          DIVDefinition divDefinition = new DIVDefinition();
          codeContainer.add(divDefinition);
          break;
        case ASSIGN:
          VariableDefinition definition = new VariableDefinition();
          definition.setName(node.getLeftChild().getValue());
          definition.setOpType(OPType.STORE);
          codeContainer.add(definition);
          break;

      }
    }
  }

  public static void main(String[] args) {
    System.out.println("Hello world");
  }
}
