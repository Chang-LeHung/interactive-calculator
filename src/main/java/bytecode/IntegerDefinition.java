package bytecode;

public class IntegerDefinition extends ByteCodeDefinition{

  private int data;

  public IntegerDefinition() {
    setOpType(OPType.LOAD_CONSTANT);
  }

  public Integer getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "LoadConstant\t" + data + "\n";
  }
}
