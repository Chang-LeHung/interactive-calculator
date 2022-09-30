package objects;

public class ICInt extends ICObject implements ICValue{

  private Integer val;

  public ICInt(int v) {
    val = v;
  }

  @Override
  public Object getValue() {
    return val;
  }

  @Override
  public String toString() {
    return "ICInt{" +
            "val=" + val +
            '}';
  }

  @Override
  public void setValue(Object v) {
    if (v instanceof Integer) {
      val = (Integer) v;
     }
    throw new RuntimeException("the parameter v should be Integer");
  }
}
