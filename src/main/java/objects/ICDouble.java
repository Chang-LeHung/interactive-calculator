package objects;

public class ICDouble extends ICObject implements ICValue {
  private Double val;

  public ICDouble(double v) {
    val = v;
  }


  @Override
  public Object getValue() {
    return val;
  }

  @Override
  public void setValue(Object v) {
    if (v instanceof Double) {
      val = (Double) v;
    }
    throw new RuntimeException("the parameter should be Double");
  }

  @Override
  public String toString() {
    return "ICDouble{" +
            "val=" + val +
            '}';
  }
}
