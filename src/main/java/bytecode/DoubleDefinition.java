package bytecode;

public class DoubleDefinition extends ByteCodeDefinition{

  double data;

  @Override
  public String toString() {
    return "STORE\t" + data + "\n";
  }

  public double getData() {
    return data;
  }

  public DoubleDefinition() {
    setOpType(OPType.STORE);
  }

  public void setData(double data) {
    this.data = data;
  }
}
