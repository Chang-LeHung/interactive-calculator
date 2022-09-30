package bytecode;

public class DoubleDefinition extends ByteCodeDefinition{

  double data;

  @Override
  public String toString() {
    return "LoadConstant\t" + data + "\n";
  }

  public Double getData() {
    return data;
  }

  public DoubleDefinition() {
    setOpType(OPType.LOAD_CONSTANT);
  }

  public void setData(double data) {
    this.data = data;
  }
}
