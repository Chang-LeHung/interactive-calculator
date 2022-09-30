package parser;

public class Node {

  public enum Type {
    NUMBER,
    IDENTIFIER,
    PLUS,
    MINUS,
    TIMES,
    DIV,
    OPERATOR,
    ASSIGN
  }

  public Node getParent() {
    return parent;
  }

  public void setParent(Node parent) {
    this.parent = parent;
  }

  private String value;
  private Type nodeType;

  @Override
  public String toString() {
    return "Node{" +
            "value='" + value + '\'' +
            ", nodeType=" + nodeType +
            ", leftChild=" + leftChild +
            ", rightChild=" + rightChild +
            '}';
  }

  private Node leftChild;
  private Node rightChild;
  private Node parent;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Type getNodeType() {
    return nodeType;
  }

  public void setNodeType(Type nodeType) {
    this.nodeType = nodeType;
  }

  public Node getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(Node leftChild) {
    this.leftChild = leftChild;
  }

  public Node getRightChild() {
    return rightChild;
  }

  public void setRightChild(Node rightChild) {
    this.rightChild = rightChild;
  }
}
