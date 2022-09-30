package bytecode;

public class DoubleDefinition extends ByteCodeDefinition{

  double data;

  @Override
  public String toString() {
    return "Load\t" + data + "\n";
  }

  public Double getData() {
    return data;
  }

  public DoubleDefinition() {
    setOpType(OPType.STORE);
  }

  public void setData(double data) {
    this.data = data;
  }
}
