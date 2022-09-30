package bytecode;

public class IntegerDefinition extends ByteCodeDefinition{

  private int data;

  public IntegerDefinition() {
    setOpType(OPType.STORE);
  }

  public int getData() {
    return data;
  }


}
