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

  public ArrayList<ByteCodeDefinition> getCodeContainer() {
    return codeContainer;
  }

  public void generateByteCode(Node node) {

    if (node != null) {
      generateByteCode(node.getLeftChild());
      generateByteCode(node.getRightChild());

      if (node.getNodeType() == Node.Type.IDENTIFIER) {
        VariableDefinition variableDefinition = new VariableDefinition();
        variableDefinition.setName(node.getValue());
        if (node.getParent().getNodeType() == Node.Type.ASSIGN) {
          variableDefinition.setOpType(ByteCodeDefinition.OPType.STORE);
        }else{
          variableDefinition.setOpType(ByteCodeDefinition.OPType.LOAD);
        }
        codeContainer.add(variableDefinition);
      }else if (node.getNodeType() == Node.Type.NUMBER) {
        if (node.getValue().contains(".")) {
          DoubleDefinition doubleDefinition = new DoubleDefinition();
          doubleDefinition.setData(Double.parseDouble(node.getValue()));
          codeContainer.add(doubleDefinition);
        }else {
          IntegerDefinition doubleDefinition = new IntegerDefinition();
          doubleDefinition.setData(Integer.parseInt(node.getValue()));
          codeContainer.add(doubleDefinition);
        }
      }else {
        if (node.getNodeType() == Node.Type.MINUS) {
          MINUSDefinition minusDefinition = new MINUSDefinition();
          minusDefinition.setOpType(ByteCodeDefinition.OPType.MINUS);
          codeContainer.add(minusDefinition);
        }else if (node.getNodeType() == Node.Type.PLUS) {
          PLUSDefinition plusDefinition = new PLUSDefinition();
          plusDefinition.setOpType(ByteCodeDefinition.OPType.PLUS);
          codeContainer.add(plusDefinition);
        }else if (node.getNodeType() == Node.Type.TIMES) {
          TIMESDefinition timesDefinition = new TIMESDefinition();
          timesDefinition.setOpType(ByteCodeDefinition.OPType.TIMES);
          codeContainer.add(timesDefinition);
        }else if (node.getNodeType() == Node.Type.DIV) {
          DIVDefinition divDefinition = new DIVDefinition();
          divDefinition.setOpType(ByteCodeDefinition.OPType.DIV);
          codeContainer.add(divDefinition);
        }
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("Hello world");
  }
}
