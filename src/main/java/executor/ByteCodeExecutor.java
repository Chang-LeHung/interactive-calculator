package executor;

import bytecode.ByteCodeDefinition;

import java.util.ArrayList;
import java.util.Stack;
import bytecode.OPType;

public class ByteCodeExecutor {

  ArrayList<ByteCodeDefinition> codePool;

  public ArrayList<ByteCodeDefinition> getCodePool() {
    return codePool;
  }

  public void setCodePool(ArrayList<ByteCodeDefinition> codePool) {
    this.codePool = codePool;
  }

  public Object run() {
    Stack<Object> executingStack = new Stack<>();
    for (ByteCodeDefinition code : codePool) {

      switch (code.getOpType()) {
        case MINUS:
          System.out.println();
        case DIV:
          System.out.println();
        case LOAD:
        case STORE:
        case TIMES:
        default:
      }
    }
    return null;
  }
}
