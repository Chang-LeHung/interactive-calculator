package bytecode;


public class ByteCodeDefinition {

    enum OPType {
      STORE,
      LOAD,
      TIMES,
      DIV,
      PLUS,
      MINUS,
    }

  private OPType opType;

  public OPType getOpType() {
    return opType;
  }

  public void setOpType(OPType opType) {
    this.opType = opType;
  }

  @Override
  public String toString() {
    return opType.toString() + "\n";
  }
}
