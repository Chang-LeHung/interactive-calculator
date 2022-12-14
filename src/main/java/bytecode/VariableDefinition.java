package bytecode;

public class VariableDefinition extends ByteCodeDefinition {

  String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return getOpType().toString() + "\t" + name + "\n";
  }
}
