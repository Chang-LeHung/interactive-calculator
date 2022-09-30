package bytecode;

public class IntegerDefinition extends ByteCodeDefinition{

  private int data;

  public IntegerDefinition() {
    setOpType(OPType.STORE);
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "Load\t" + data + "\n";
  }
}
