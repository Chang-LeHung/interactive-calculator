package bytecode;

public class DoubleDefinition extends ByteCodeDefinition{

  double data;

  public double getData() {
    return data;
  }

  public DoubleDefinition() {
    setOpType(OPType.STORE);
  }
}
