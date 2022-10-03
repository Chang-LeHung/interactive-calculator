package objects;

public class ICIntBinary extends ICInt{
  public ICIntBinary(int v) {
    super(v);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    int v = (int) getValue();
    builder.append("ICIntBinary{val=");
    for (int i = 31; i >= 0; i--) {
      if ((i + 1) % 4 == 0 && i != 31)
        builder.append("_");
      if (((v >> i) & 1) == 1) {
        builder.append("1");
      }
      else {
        builder.append("0");
      }
    }
    builder.append("}");
    return builder.toString();
  }
}
