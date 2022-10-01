package bytecode;

import java.util.function.Function;

public class FunctionDefinition extends ByteCodeDefinition
        implements Function<Double, Double> {

  public enum FunctionType {
    TANH,
    TAN,
    SIN,
    COS,
    COT,
    POW,
    EXP,
    LOG,
    LOG10
  }

  private FunctionType functionType;
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FunctionType getFunctionType() {
    return functionType;
  }

  public void setFunctionType(FunctionType functionType) {
    this.functionType = functionType;
  }

  public FunctionDefinition() {
    setOpType(OPType.FUNCTION);
  }


  @Override
  public Double apply(Double o) {
    stringToType();
    return calculate(o);
  }

  private void stringToType() {
    if (name.equalsIgnoreCase("tanh")) {
      functionType = FunctionType.TANH;
    }else if (name.equalsIgnoreCase("tan")) {
      functionType = FunctionType.TAN;
    }else if (name.equalsIgnoreCase("sin")) {
      functionType = FunctionType.SIN;
    }else if (name.equalsIgnoreCase("cos")) {
      functionType = FunctionType.COS;
    }else if (name.equalsIgnoreCase("cot")) {
      functionType = FunctionType.COT;
    }else if (name.equalsIgnoreCase("log")) {
      functionType = FunctionType.LOG;
    }else {
      functionType = FunctionType.LOG10;
    }
  }

  private double calculate(double d) {
    switch (functionType) {
      case TAN:
        return Math.tan(d);
      case TANH:
        return Math.tanh(d);
      case SIN:
        return Math.sin(d);
      case COS:
        return Math.cos(d);
      case COT:
        return 1 / Math.tan(d);
      case EXP:
        return Math.exp(d);
      case LOG:
        return Math.log(d);
      case LOG10:
        return Math.log10(d);

    }
    return 0;
  }


}
