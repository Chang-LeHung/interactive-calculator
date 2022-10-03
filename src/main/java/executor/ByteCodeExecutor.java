package executor;

import builtin.BuiltInCommand;
import bytecode.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import objects.ICDouble;
import objects.ICInt;
import objects.ICIntBinary;
import objects.ICObject;

public class ByteCodeExecutor {

  private ArrayList<ByteCodeDefinition> codePool;
  private final Stack<ICObject> operandStack = new Stack<>();
  private final HashMap<String, ICObject> symbolTable = new HashMap<>();

  public ArrayList<ByteCodeDefinition> getCodePool() {
    return codePool;
  }

  public void setCodePool(ArrayList<ByteCodeDefinition> codePool) {
    this.codePool = codePool;
  }

  public ICObject run(ArrayList<ByteCodeDefinition> codePool) {
    operandStack.clear();
    try {
      for (ByteCodeDefinition code : codePool) {

        switch (code.getOpType()) {
          case PLUS:
            executePlus();
            break;
          case MINUS:
            executeMinus();
            break;
          case DIV:
            executeDiv();
            break;
          case LOAD:
            executeLoad(code);
            break;
          case STORE:
            executeStore(code);
            break;
          case TIMES:
            executeTimes();
            break;
          case LOAD_CONSTANT:
            executeLoadConstant(code);
            break;
          case FUNCTION:
            executeFunction(code);
            break;
          case AND:
            executeAnd(code);
            break;
          case OR:
            executeOr(code);
            break;
        }
      }
    }catch (Exception e) {
      System.err.println(e.getMessage());;
      return null;
    }
    if (operandStack.isEmpty()) {
      return null;
    }
    return operandStack.pop();
  }

  private void executeAnd(ByteCodeDefinition codeDefinition) {
    ICObject o2 = operandStack.pop();
    ICObject o1 = operandStack.pop();
    if (o1 instanceof ICInt && o2 instanceof ICInt) {
      int a = (int) ((ICInt) o1).getValue();
      int b = (int) ((ICInt) o2).getValue();
      ICInt icInt = new ICInt(a & b);
      operandStack.push(icInt);
      return;
    }
    throw new RuntimeException("can not take and on none integer data");
  }

  private void executeOr(ByteCodeDefinition codeDefinition) {
    ICObject o2 = operandStack.pop();
    ICObject o1 = operandStack.pop();
    if (o1 instanceof ICInt && o2 instanceof ICInt) {
      int a = (int) ((ICInt) o1).getValue();
      int b = (int) ((ICInt) o2).getValue();
      ICInt icInt = new ICInt(a | b);
      operandStack.push(icInt);
      return;
    }
    throw new RuntimeException("can not take and on none integer data");
  }

  private void executeFunction(ByteCodeDefinition codeDefinition) {
    if (codeDefinition instanceof FunctionDefinition) {
      ICObject pop = operandStack.pop();
      if (((FunctionDefinition) codeDefinition).getName().equalsIgnoreCase("bin")) {
        ICIntBinary icIntBinary = new ICIntBinary((Integer) ((ICInt) pop).getValue());
        operandStack.push(icIntBinary);
      }else {
        double t;
        if (pop instanceof ICDouble) {
          t = (double) ((ICDouble) pop).getValue();
        }else {
          t = (Integer) ((ICInt) pop).getValue();
        }
        Double ans = (Double) ((FunctionDefinition) codeDefinition).apply(t);
        operandStack.push(new ICDouble(ans));
      }
      return;
    }
    throw new RuntimeException("codeDefinition should be FunctionDefinition");
  }

  private void executeLoadConstant(ByteCodeDefinition codeDefinition) {
    if (codeDefinition instanceof IntegerDefinition) {
      operandStack.push(
              new ICInt(((IntegerDefinition) codeDefinition).getData())
      );
    }else if (codeDefinition instanceof DoubleDefinition) {
      operandStack.push(
              new ICDouble(((DoubleDefinition) codeDefinition).getData())
      );
    }
  }

  private void executeLoad(ByteCodeDefinition codeDefinition) {
    if (codeDefinition.getOpType() == OPType.LOAD) {
      String name = ((VariableDefinition) codeDefinition).getName();
      if (!matchBuiltInCommand(name)) {
        ICObject icObject = symbolTable.get(name);
        if (icObject == null) {
          throw new RuntimeException(name + " not in symbol table");
        }
        operandStack.push(icObject);
      }
      return;
    }
    throw new RuntimeException("optype is not LOAD");
  }

  private void executeStore(ByteCodeDefinition codeDefinition) {
    String name = ((VariableDefinition) codeDefinition).getName();
    if (!matchBuiltInCommand(name))
      symbolTable.put(name, operandStack.pop());
  }

  private boolean matchBuiltInCommand(String name) {
    if (BuiltInCommand.isBuiltInCommand(name)) {
      if (name.equalsIgnoreCase("pi")) {
        ICDouble icDouble = new ICDouble(Math.PI);
        operandStack.push(icDouble);
      }else if (name.equalsIgnoreCase("e")) {
        ICDouble icDouble = new ICDouble(Math.PI);
        operandStack.push(icDouble);
      }else if (name.equalsIgnoreCase("l")) {
        System.out.println("============================");
        System.out.println("\033[0;31m>>> All table symbols and variables are as follows <<<");
        symbolTable.forEach((x, y) -> {
          System.out.print(x + " = " + y + ";\t");
        });
        System.out.println("\033[0m");
        System.out.println("============================");
      }
      return true;
    }
    return false;
  }


  private void executeMinus() {
    ICObject o2 = operandStack.pop();
    ICObject o1 = operandStack.pop();
    double t1 = traitOperand(o1);
    double t2 = traitOperand(o2);

    if (o1 instanceof ICDouble || o2 instanceof ICDouble)
      operandStack.push(new ICDouble(t1 - t2));
    else
      operandStack.push(new ICInt((int)(t1 - t2)));
  }

  private void executePlus() {
    ICObject o2 = operandStack.pop();
    ICObject o1 = operandStack.pop();
    double t1 = traitOperand(o1);
    double t2 = traitOperand(o2);

    if (o1 instanceof ICDouble || o2 instanceof ICDouble)
      operandStack.push(new ICDouble(t1 + t2));
    else
      operandStack.push(new ICInt((int)(t1 + t2)));
  }

  private void executeTimes() {
    ICObject o2 = operandStack.pop();
    ICObject o1 = operandStack.pop();
    double t1 = traitOperand(o1);
    double t2 = traitOperand(o2);

    if (o1 instanceof ICDouble || o2 instanceof ICDouble)
      operandStack.push(new ICDouble(t1 * t2));
    else
      operandStack.push(new ICInt((int)(t1 * t2)));
  }

  private void executeDiv() {
    ICObject o2 = operandStack.pop();
    ICObject o1 = operandStack.pop();
    double t1 = traitOperand(o1);
    double t2 = traitOperand(o2);

    operandStack.push(new ICDouble(t1 / t2));
  }

  private double traitOperand(ICObject o) {
    if (o instanceof ICDouble)
      return (double) ((ICDouble) o).getValue();
    else if (o instanceof ICInt)
      return (int) ((ICInt) o).getValue();
    throw new RuntimeException("can not trait double or int from ICObject o");
  }

}
