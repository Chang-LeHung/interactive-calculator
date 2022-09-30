package util;

import parser.Node;

public class DFS {

  private StringBuilder nodes = new StringBuilder();
  private StringBuilder edges = new StringBuilder();
  private int num;

  public DFS() {
    num = 1;
  }

  public int dumpAST(Node node) {
    if (node != null) {
      String tmp;
      if (node.getValue() == null)
        tmp = "empty";
      else
        tmp = node.getValue();
      nodes.append(num).append("[label=\"").append(tmp).append("\"];\n");
      int mn = num++;
      int n = dumpAST(node.getLeftChild());
      if (n != -1)
        edges.append(mn).append("->").append(n).append(";\n");
      n = dumpAST(node.getRightChild());
      if (n != -1)
        edges.append(mn).append("->").append(n).append(";\n");
      return mn;
    }
    return -1;
  }


  public void printDotContent() {
    System.out.println(getNodes().toString());
    System.out.println(getEdges().toString());
  }

  public StringBuilder getNodes() {
    return nodes;
  }

  public void setNodes(StringBuilder nodes) {
    this.nodes = nodes;
  }

  public StringBuilder getEdges() {
    return edges;
  }

  public void setEdges(StringBuilder edges) {
    this.edges = edges;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }
}
