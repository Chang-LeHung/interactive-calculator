package objects;

public class ICObject {
  ICType icType;

  public ICType getIcType() {
    return icType;
  }

  public void setIcType(ICType icType) {
    this.icType = icType;
  }

  @Override
  public String toString() {
    return "ICObject{" +
            "icType=" + icType +
            '}';
  }
}
